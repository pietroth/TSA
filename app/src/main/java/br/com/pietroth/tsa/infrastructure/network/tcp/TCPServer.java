package br.com.pietroth.tsa.infrastructure.network.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import br.com.pietroth.tsa.core.engine.network.transport.Server;
import br.com.pietroth.tsa.core.engine.network.transport.Connection;
import br.com.pietroth.tsa.core.engine.network.transport.ConnectionCreatedListener;

import java.util.List;
import java.util.ArrayList;

public class TCPServer implements Server {
    private final int port;
    private final ExecutorService clientPool;
    private final List<ConnectionCreatedListener> listeners = new ArrayList<>();

    private TCPServer(Builder builder) {
        this.port = builder.port;
        this.clientPool = builder.clientPool;
    }

    @Override
    public void subscribe(ConnectionCreatedListener listener) {
        listeners.add(listener);
    }

    @Override
    public void unsubscribe(ConnectionCreatedListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void notifyConnectionCreated(Connection connection) {
        for (ConnectionCreatedListener listener : listeners) {
            listener.onConnectionCreated(connection);
        }
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TCP Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                TCPConnection connection = new TCPConnection(clientSocket, 1);
                notifyConnectionCreated(connection);

                clientPool.submit(
                    connection
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int port;
        private ExecutorService clientPool;

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder clientPool(ExecutorService clientPool) {
            this.clientPool = clientPool;
            return this;
        }

        public TCPServer build() {
            if (port <= 0) throw new IllegalStateException("Port must be set");
            if (clientPool == null) throw new IllegalStateException("ExecutorService is required");

            return new TCPServer(this);
        }
    }
}