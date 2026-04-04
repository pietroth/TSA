package br.com.pietroth.tsa.core.network.protocol;

import br.com.pietroth.tsa.core.network.transport.Connection;
import br.com.pietroth.tsa.core.network.transport.ConnectionReceivedListener;

public class EventGateway implements ConnectionReceivedListener {

    @Override
    public void onConnectionReceived(Connection connection, byte[] data) {
        // Handle the received data
    }
}
