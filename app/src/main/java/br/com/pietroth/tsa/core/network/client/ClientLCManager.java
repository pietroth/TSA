package br.com.pietroth.tsa.core.network.client;

import br.com.pietroth.tsa.core.network.transport.ConnectionCreatedListener;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.pietroth.tsa.core.network.transport.Connection;

public class ClientLCManager implements ConnectionCreatedListener {
    private final Map<Integer, Client> clients;
    private final AtomicInteger idGenerator = new AtomicInteger(0);

    public ClientLCManager(int maxClients) {
        this.clients = new ConcurrentHashMap<>();
    }

    @Override
    public synchronized void onConnectionCreated(Connection connection) {
        int id = idGenerator.getAndIncrement();

        Client client = new Client.Builder()
                .id(id)
                .connection(connection)
                .build();

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
}