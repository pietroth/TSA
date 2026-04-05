package br.com.pietroth.tsa.core.network.transport;

public interface ConnectionReceivedListener {
    void onConnectionReceived(Connection connection, byte[] data);
}