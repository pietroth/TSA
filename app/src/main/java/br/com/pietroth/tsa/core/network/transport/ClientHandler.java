package br.com.pietroth.tsa.core.network.transport;

import java.net.Socket;

import br.com.pietroth.tsa.core.event.EventData;
import br.com.pietroth.tsa.core.event.EventDecoder;
import br.com.pietroth.tsa.core.event.EventDispatcher;
import br.com.pietroth.tsa.core.event.Event;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final EventDecoder decoder;
    private final Connection connection;
    private final EventDispatcher dispatcher;

    private ClientHandler(Builder builder) {
        this.clientSocket = builder.clientSocket;
        this.decoder = builder.decoder;
        this.connection = builder.connection;
        this.dispatcher = builder.dispatcher;
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] raw = connection.read();
                Event<? extends EventData> event = decoder.decode(raw);
                dispatcher.enqueue(event);
            } catch (Exception e) {
                System.out.println("Client disconnected: " + clientSocket.getRemoteSocketAddress());
                break;
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Socket clientSocket;
        private EventDecoder decoder;
        private Connection connection;
        private EventDispatcher dispatcher;

        public Builder clientSocket(Socket clientSocket) {
            this.clientSocket = clientSocket;
            return this;
        }

        public Builder decoder(EventDecoder decoder) {
            this.decoder = decoder;
            return this;
        }

        public Builder connection(Connection connection) {
            this.connection = connection;
            return this;
        }

        public Builder dispatcher(EventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }

        public ClientHandler build() {
            if (clientSocket == null) throw new IllegalStateException("clientSocket is required");
            if (decoder == null) throw new IllegalStateException("decoder is required");
            if (connection == null) throw new IllegalStateException("connection is required");
            if (dispatcher == null) throw new IllegalStateException("dispatcher is required");
            return new ClientHandler(this);
        }
    }
}