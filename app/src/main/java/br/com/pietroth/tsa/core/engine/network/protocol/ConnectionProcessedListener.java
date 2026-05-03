package br.com.pietroth.tsa.core.engine.network.protocol;

import br.com.pietroth.tsa.core.engine.network.transport.Connection;

public interface ConnectionProcessedListener {
    void onConnectionProcessed(Connection connection);
}
