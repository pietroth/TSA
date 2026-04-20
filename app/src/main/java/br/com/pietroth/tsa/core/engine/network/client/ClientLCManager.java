package br.com.pietroth.tsa.core.engine.network.client;

import br.com.pietroth.tsa.core.engine.network.transport.ConnectionCreatedListener;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
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

    public void sendTo(List<Integer> ids, byte[] data) {
        for (int id : ids) {
            Client client = clients.get(id);
            if (client != null) {
                try {
                    client.getConnection().send(data);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void sendToAll(byte[] data) {
        clients.values().forEach(client -> {
            try {
                client.getConnection().send(data);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        });
    }
}