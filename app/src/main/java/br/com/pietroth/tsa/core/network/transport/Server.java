package br.com.pietroth.tsa.core.network.transport;

public interface Server {
    void subscribe(ConnectionCreatedListener listener);
    void unsubscribe(ConnectionCreatedListener listener);
    void notifyConnectionCreated(Connection connection);

    void start();
    void stop();
}
