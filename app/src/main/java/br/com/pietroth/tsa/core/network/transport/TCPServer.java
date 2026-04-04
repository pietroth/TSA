package br.com.pietroth.tsa.core.network.transport;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.List;
import java.util.ArrayList;

import br.com.pietroth.tsa.core.event.EventDecoder;
import br.com.pietroth.tsa.core.event.EventDispatcher;
import br.com.pietroth.tsa.core.event.EventEncoder;

public class TCPServer implements Server {
    private final int port;
    private final ExecutorService clientPool;
    private final EventEncoder encoder;
    private final List<ConnectionCreatedListener> listeners = new ArrayList<>();

    private TCPServer(Builder builder) {
        this.port = builder.port;
        this.clientPool = builder.clientPool;
        this.encoder = builder.encoder;
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
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TCP Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                TCPConnection connection = new TCPConnection(clientSocket, encoder);
                notifyConnectionCreated(connection);

                clientPool.submit(
                    connection
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        clientPool.shutdownNow();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int port;
        private ExecutorService clientPool;
        private EventDecoder decoder;
        private EventDispatcher dispatcher;
        private EventEncoder encoder;

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder clientPool(ExecutorService clientPool) {
            this.clientPool = clientPool;
            return this;
        }

        public Builder decoder(EventDecoder decoder) {
            this.decoder = decoder;
            return this;
        }

        public Builder dispatcher(EventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }

        public Builder encoder(EventEncoder encoder) {
            this.encoder = encoder;
            return this;
        }

        public TCPServer build() {
            if (port <= 0) throw new IllegalStateException("Port must be set");
            if (clientPool == null) throw new IllegalStateException("ExecutorService is required");
            if (decoder == null) throw new IllegalStateException("EventDecoder is required");
            if (dispatcher == null) throw new IllegalStateException("EventDispatcher is required");
            if (encoder == null) throw new IllegalStateException("EventEncoder is required");

            return new TCPServer(this);
        }
    }
}