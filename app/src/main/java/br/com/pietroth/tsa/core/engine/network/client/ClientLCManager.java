package br.com.pietroth.tsa.core.engine.network.client;

import java.io.IOException;
import java.lang.foreign.MemorySegment;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.pietroth.tsa.core.engine.network.protocol.IntentionGateway;
import br.com.pietroth.tsa.core.engine.network.transport.Connection;
import br.com.pietroth.tsa.core.engine.network.transport.ConnectionCreatedListener;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntStack;

public class ClientLCManager implements ConnectionCreatedListener {
    private final Client[] clients;
    private final IntStack freeIds; 
    private IntentionGateway intentionGateway;
    private final int maxClients;

    public ClientLCManager(int maxClients) {
        this.maxClients = maxClients;
        this.clients = new Client[maxClients];

        this.freeIds = new IntArrayList(maxClients);
        for (int i = maxClients - 1; i >= 0; i--) {
            freeIds.push(i);
        }
    }

    public void setIntentionGateway(IntentionGateway intentionGateway) {
        this.intentionGateway = intentionGateway;
    }

    @Override
    public synchronized void onConnectionCreated(Connection connection) {
        if (freeIds.isEmpty()) {
            throw new IllegalStateException("No available client IDs. Maximum number of clients reached: " + maxClients);
        }

        int id = freeIds.popInt();
        
        connection.setId(id);

        Client client = new Client.Builder()
                .id(id)
                .connection(connection)
                .build();

        client.getConnection().subscribe(intentionGateway);

        clients[id] = client;
    }

    public Collection<Client> getClientsView() {
        return Arrays.stream(clients)
                     .filter(Objects::nonNull)
                     .collect(Collectors.toList());
    }

    public Client getClientById(int id) {
        if (id < 0 || id >= maxClients) return null;
        return clients[id];
    }

    public void disconnectClient(int id) {
        if (id >= 0 && id < maxClients && clients[id] != null) {
            clients[id] = null;
            freeIds.push(id);
        }
    }

    public void sendTo(int id, MemorySegment segment) {
        Client client = getClientById(id);
        if (client == null) {
            return;
        }

        sendTo(client, segment);
    }

    public void sendTo(int[] ids, MemorySegment segment) {
        for (int id : ids) {
            sendTo(id, segment);
        }
    }

    public void sendToAll(MemorySegment segment) {
        for (Client client : clients) {
            if (client != null) {
                sendTo(client, segment);
            }
        }
    }

    private void sendTo(Client client, MemorySegment segment) {
        try {
            client.getConnection().send(segment);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
