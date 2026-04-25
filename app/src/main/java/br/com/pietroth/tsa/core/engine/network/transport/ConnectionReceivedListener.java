package br.com.pietroth.tsa.core.engine.network.transport;

import java.lang.foreign.MemorySegment;

public interface ConnectionReceivedListener {
    void onConnectionReceived(Connection connection, MemorySegment segment);
}