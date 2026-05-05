package br.com.pietroth.tsa.core.engine.network.protocol;

import br.com.pietroth.tsa.core.engine.communication.intention.Intention;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.engine.communication.response.IR;
import br.com.pietroth.tsa.core.engine.communication.response.IRPublisherSingleton;
import br.com.pietroth.tsa.core.engine.network.transport.Connection;
import br.com.pietroth.tsa.core.engine.network.transport.ConnectionReceivedListener;
import br.com.pietroth.tsa.core.engine.runtime.ComponentResolver;
import br.com.pietroth.tsa.core.engine.runtime.InnerProcessor;
import br.com.pietroth.tsa.core.engine.communication.MIDFData;

import java.lang.foreign.MemorySegment;

public class IntentionGateway implements ConnectionReceivedListener {
    private final ComponentResolver processingPipeline;
    private final IntentionDecoder decoder;

    public IntentionGateway(ComponentResolver processingPipeline, IntentionDecoder decoder) {
        this.processingPipeline = processingPipeline;
        this.decoder = decoder;
    }

    @Override
    public void onConnectionReceived(Connection connection, MemorySegment segment) {
        System.out.println("Received intention. OriginId: " + connection.getId() + ", Size: " + segment.byteSize());
        int id = decoder.getId(segment);
        InnerProcessor<?> processor = processingPipeline.lookup((id >> 6) & 0x3F, id & 0x3F);

        if (processor == null) 
            throw new IllegalStateException("No processor found for intention id " + id);

        processIntention(processor, connection, segment);
        System.out.println("Processed intention. Id: " + id + ", OriginId: " + connection.getId());
    }

    private <T extends MIDFData> void processIntention(InnerProcessor<T> processor, Connection connection, MemorySegment segment) {
        Intention<T> intention = decoder.decode(segment, connection.getId(), processor.codec());

        int validationResult = processor.validator().validate(intention);
        if (validationResult != 0) // validation failed, publish IR and return
        {
            IRPublisherSingleton.get().publish(new IR.Builder()
                .success(intention.getCorrelationId(), (byte) 0)
                .build(),
                intention.getCorrelationId()
            );
            return;
        }

        processor.useCase().execute(intention.getOriginId(), intention.getData());
        IRPublisherSingleton.get().publish(new IR.Builder()
            .success(intention.getCorrelationId(), (byte) 0)
            .build(), intention.getOriginId());
    }
}