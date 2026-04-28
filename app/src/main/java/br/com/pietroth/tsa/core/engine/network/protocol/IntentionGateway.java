package br.com.pietroth.tsa.core.engine.network.protocol;

import br.com.pietroth.tsa.core.engine.network.transport.Connection;
import br.com.pietroth.tsa.core.engine.network.transport.ConnectionReceivedListener;
import br.com.pietroth.tsa.core.engine.runtime.DataProcessingPipeline;

import java.lang.foreign.MemorySegment;

public class IntentionGateway implements ConnectionReceivedListener {
    private final DataProcessingPipeline processingPipeline;

    public IntentionGateway(DataProcessingPipeline processingPipeline) {
        this.processingPipeline = processingPipeline;
    }

    @Override
    public void onConnectionReceived(Connection connection, MemorySegment segment) {
        processingPipeline.processIntention(segment, connection.getId());
    }
}