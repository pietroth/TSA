package br.com.pietroth.tsa.core.engine.runtime;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.MIDFEncoder;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import br.com.pietroth.tsa.core.engine.communication.event.Event;
import br.com.pietroth.tsa.core.engine.communication.intention.Intention;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionValidator;
import br.com.pietroth.tsa.core.engine.communication.response.IR;
import br.com.pietroth.tsa.core.engine.communication.response.IRCodec;
import br.com.pietroth.tsa.core.engine.communication.response.IRPublisherSingleton;
import br.com.pietroth.tsa.core.engine.network.MessageDeliveryHandler;
import br.com.pietroth.tsa.core.engine.usecase.UseCase;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

@SuppressWarnings("rawtypes")
public final class DataProcessingPipeline {
    private final InnerProcessor[] processors = new InnerProcessor[4096];

    private final IntentionDecoder intentionDecoder;
    private final MIDFEncoder midfEncoder;
    private final IRCodec irCodec;

    private final MessageDeliveryHandler deliveryHandler;

    public DataProcessingPipeline(
        IntentionDecoder intentionDecoder,
        MessageDeliveryHandler deliveryHandler,
        MIDFEncoder midfEncoder,
        IRCodec irCodec) 
    {
        this.intentionDecoder = intentionDecoder;
        this.deliveryHandler = deliveryHandler;
        this.midfEncoder = midfEncoder;
        this.irCodec = irCodec;
    }

    public <T extends MIDFData> void register(
        int family,
        int type,
        IntentionValidator<T> validator,
        UseCase<T> useCase,
        Codec<T> codec)
    {
        processors[pack(family, type)] = new InnerProcessor<>(validator, useCase, codec);
    }

    public void processIntention(MemorySegment segment, int originId) {
        System.out.println("Processing intention from originId=" + originId);
        int key = intentionDecoder.getId(segment);
        InnerProcessor<?> processor = processors[key];

        if (processor == null) return;

        int result = executeIntention(processor, segment, originId);
        IRPublisherSingleton.get().publish(new IR(result, originId));
    }

    @SuppressWarnings("unchecked")
    public void processEvent(Arena arena, Event<? extends MIDFData> event) {
        System.out.println("Processing event: family=" + event.getFamily() + " type=" + event.getType());
        int key = pack(event.getFamily(), event.getType());
        InnerProcessor<?> processor = processors[key];

        if (processor == null) {
            throw new IllegalStateException(
                "No processor registered for event family=" + event.getFamily() + " type=" + event.getType()
            );
        }

        Codec<?> codec = processor.codec;

        MemorySegment segment = midfEncoder.encode(arena, (Event<MIDFData>) event, (Codec<MIDFData>) codec);
        deliveryHandler.deliveryEvent(segment, event.getOriginId(), event.getTarget());
    }

    public void processIR(Arena arena, IR ir) {
        MemorySegment segment = irCodec.encode(arena, ir);
        deliveryHandler.deliveryIr(segment, ir.getCorrelationId());
    }

    private static int pack(int family, int type) {
        if ((family & ~0x3F) != 0 || (type & ~0x3F) != 0) {
            throw new IllegalArgumentException("family/type out of range");
        }
        return ((family & 0x3F) << 6) | (type & 0x3F);
    }

    private record InnerProcessor<T extends MIDFData>(
        IntentionValidator<T> validator,
        UseCase<T> useCase,
        Codec<T> codec
    ) {}

    private <T extends MIDFData> int executeIntention(InnerProcessor<T> processor, MemorySegment segment, int originId) {
        Intention<T> intention = intentionDecoder.decode(segment, originId, processor.codec);

        if (processor.validator != null) {
            if (processor.validator.validate(intention) < 1) {
                return -1;
            }
        }

        if (processor.useCase != null) {
            processor.useCase.execute(intention.getData());
            return 0; // success
        }

        return -1;
    }
}
