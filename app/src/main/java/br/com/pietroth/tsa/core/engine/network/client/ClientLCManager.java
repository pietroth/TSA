package br.com.pietroth.tsa.core.engine.network.client;

import br.com.pietroth.tsa.core.engine.network.transport.ConnectionCreatedListener;

import java.io.IOException;
import java.lang.foreign.MemorySegment;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.pietroth.tsa.core.engine.network.protocol.IntentionGateway;
import br.com.pietroth.tsa.core.engine.network.transport.Connection;

public class ClientLCManager implements ConnectionCreatedListener {
    private final Map<Integer, Client> clients;
    private final AtomicInteger idGenerator = new AtomicInteger(0);
    private final IntentionGateway intentionGateway;

    public ClientLCManager(int maxClients, IntentionGateway intentionGateway) {
        this.clients = new ConcurrentHashMap<>();
        this.intentionGateway = intentionGateway;
    }

    @Override
    public synchronized void onConnectionCreated(Connection connection) {
        int id = idGenerator.getAndIncrement();
        connection.setId(id); // Don't remove, it links client id with connection id

        Client client = new Client.Builder()
                .id(id)
                .connection(connection)
                .build();
                
        client.getConnection().subscribe(intentionGateway);

        if (clients.putIfAbsent(id, client) != null) {
            throw new IllegalStateException("Duplicate client ID: " + id);
        }
    }

    public Collection<Client> getClientsView() {
        return Collections.unmodifiableCollection(clients.values());
    }

    public Client getClientById(int id) {
        return clients.get(id);
    }

    public void disconnectClient(int id) {
        clients.remove(id);
    }

    public void sendTo(int[] ids, MemorySegment segment) { 
        for (int i = 0; i < ids.length; i++) {
            Client client = clients.get(ids[i]);
            if (client != null) {
                try {
                    client.getConnection().send(segment);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void sendToAll(MemorySegment segment) {
        for (Client client : clients.values()) {
            try {
                client.getConnection().send(segment);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}