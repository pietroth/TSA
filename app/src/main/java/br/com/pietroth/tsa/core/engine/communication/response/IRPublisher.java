package br.com.pietroth.tsa.core.engine.communication.response;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import br.com.pietroth.tsa.core.engine.network.MessageDeliveryHandler;

public class IRPublisher {
    private final IRCodec codec;
    private final MessageDeliveryHandler delivery;

    public IRPublisher(IRCodec codec, MessageDeliveryHandler delivery) {
        this.codec = codec;
        this.delivery = delivery;
    }

    public void publish(IR ir, int originId) {
        try (Arena arena = Arena.ofShared()) {
           MemorySegment segment = codec.encode(arena, ir);

           delivery.deliveryIr(segment, originId);
           System.out.println("Published IR. CorrelationId: " + ir.getCorrelationId() + ", Status: " + ir.getStatus() + ", OriginId: " + originId);
        }
    }
}
