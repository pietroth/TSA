package br.com.pietroth.tsa.core.engine.communication.event;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.MIDFEncoder;
import br.com.pietroth.tsa.core.engine.network.MessageDeliveryHandler;
import br.com.pietroth.tsa.core.engine.runtime.ComponentResolver;
import br.com.pietroth.tsa.core.engine.runtime.InnerProcessor;

public class EventPublisher {
    private final ComponentResolver processingPipeline;
    private final MIDFEncoder encoder;
    private final MessageDeliveryHandler delivery;

    public EventPublisher(ComponentResolver processingPipeline, MIDFEncoder encoder, MessageDeliveryHandler delivery) {
        this.processingPipeline = processingPipeline;
        this.encoder = encoder;
        this.delivery = delivery;
    }

    public void publish(Event<? extends MIDFData> event) {
        processEvent(event);
        System.out.println("Published event. Family: " + event.getFamily() + ", Type: " + event.getType() + ", OriginId: " + event.getOriginId() + ", Target Size: " + event.getTarget().modifier.toArray().length);
    }

    @SuppressWarnings("unchecked")
    private <T extends MIDFData> void processEvent(Event<T> event) {
        try (Arena arena = Arena.ofConfined()) {
            InnerProcessor<T> processor = (InnerProcessor<T>) processingPipeline.lookup(event.getFamily(), event.getType());
            
            if (processor == null) {
                throw new IllegalStateException("No processor found for event family " + event.getFamily() + " and type " + event.getType());
            }

            MemorySegment segment = encoder.encode(arena, event, processor.codec());
            
            delivery.deliveryEvent(segment, event.getOriginId(), event.getTarget());
        }
    }
}
