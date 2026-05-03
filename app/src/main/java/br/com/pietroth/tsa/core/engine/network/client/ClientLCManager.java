package br.com.pietroth.tsa.core.engine.network.client;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import br.com.pietroth.tsa.core.engine.network.NetworkAggregatorSingleton;
import br.com.pietroth.tsa.core.engine.network.protocol.ConnectionProcessedListener;
import br.com.pietroth.tsa.core.engine.network.protocol.IntentionGateway;
import br.com.pietroth.tsa.core.engine.network.transport.Connection;
import br.com.pietroth.tsa.core.engine.network.transport.ConnectionCreatedListener;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;

// LC = LifeCycle

public class ClientLCManager implements ConnectionCreatedListener {
    private final Client[] clients;
    private final IntStack freeIds; 
    private IntentionGateway intentionGateway;
    private final int maxClients;

    private final ObjectList<ConnectionProcessedListener> listeners = new ObjectArrayList<>();

    public ClientLCManager(int maxClients, IntentionGateway intentionGateway) {
        this.intentionGateway = intentionGateway;
        this.maxClients = maxClients;
        this.clients = new Client[maxClients];

        this.freeIds = new IntArrayList(maxClients);
        for (int i = maxClients - 1; i >= 0; i--) {
            freeIds.push(i);
        }
    }

    @Override
    public synchronized void onConnectionCreated(Connection connection) {
        if (freeIds.isEmpty()) {
            throw new IllegalStateException("No available client IDs. Maximum number of clients reached: " + maxClients);
        }

        int id = freeIds.popInt();

        System.out.println(connection.getId() + " connected. Assigned client ID: " + id);
        System.out.println("New connection created with ID: " + id);
        
        connection.setId(id); // This links created Id with connection Id; Don't remove it!

        System.out.println("New Id linked to connection: " + connection.getId());

        Client client = new Client.Builder()
                .id(id)
                .connection(connection)
                .build();

        client.getConnection().subscribe(intentionGateway);

        clients[id] = client;
        notifyConnectionProcessed(connection);
    }

    public Client[] getClients() {
        return clients;
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
        for (int i = 0; i < maxClients; i++) {
            Client client = clients[i];
            if (client != null) {
                sendTo(client, segment);
            }
        }
    }

    private void sendTo(Client client, MemorySegment segment) {
        NetworkAggregatorSingleton.get().append(client.getId(), segment.toArray(ValueLayout.JAVA_BYTE));
    }

    public void subscribe(ConnectionProcessedListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(ConnectionProcessedListener listener) {
        listeners.remove(listener);
    }

    public void notifyConnectionProcessed(Connection connection) {
        for (ConnectionProcessedListener listener : listeners) {
            listener.onConnectionProcessed(connection);
        }
    }
}
