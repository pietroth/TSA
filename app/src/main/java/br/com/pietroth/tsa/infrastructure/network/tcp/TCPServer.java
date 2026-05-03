package br.com.pietroth.tsa.infrastructure.network.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import br.com.pietroth.tsa.core.engine.network.transport.Server;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import br.com.pietroth.tsa.core.engine.network.transport.Connection;
import br.com.pietroth.tsa.core.engine.network.transport.ConnectionCreatedListener;

public class TCPServer implements Server {
    private final int port;
    private final ExecutorService clientPool;
    private final ObjectList<ConnectionCreatedListener> listeners = new ObjectArrayList<>();

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

                TCPConnection connection = new TCPConnection(clientSocket);
                notifyConnectionCreated(connection);

                clientPool.execute(connection);
                System.out.println("Client connection submitted to thread pool: " + clientSocket.getRemoteSocketAddress());
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