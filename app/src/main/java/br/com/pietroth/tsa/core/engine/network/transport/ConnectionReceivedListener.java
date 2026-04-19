package br.com.pietroth.tsa.core.engine.network.transport;

public interface ConnectionReceivedListener {
    void onConnectionReceived(Connection connection, byte[] data);
}