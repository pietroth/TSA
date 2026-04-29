package br.com.pietroth.tsa.core.engine.runtime;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.MIDFEncoder;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import br.com.pietroth.tsa.core.engine.communication.event.Event;
import br.com.pietroth.tsa.core.engine.communication.event.EventDeliveryHandler;
import br.com.pietroth.tsa.core.engine.communication.intention.Intention;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionValidator;
import br.com.pietroth.tsa.core.engine.usecase.UseCase;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

@SuppressWarnings("rawtypes")
public final class DataProcessingPipeline {
    private final InnerProcessor[] processors = new InnerProcessor[4096];

    private final IntentionDecoder intentionDecoder;
    private final MIDFEncoder midfEncoder;
    private final EventDeliveryHandler deliveryHandler;

    public DataProcessingPipeline(IntentionDecoder intentionDecoder, EventDeliveryHandler deliveryHandler, MIDFEncoder midfEncoder) {
        this.intentionDecoder = intentionDecoder;
        this.deliveryHandler = deliveryHandler;
        this.midfEncoder = midfEncoder;
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
        int key = intentionDecoder.getId(segment);
        InnerProcessor<?> processor = processors[key];

        if (processor == null) return;

        executeIntention(processor, segment, originId);
    }

    @SuppressWarnings("unchecked")
    public void processEvent(Arena arena, Event<? extends MIDFData> event) {
        int key = pack(event.getFamily(), event.getType());
        Codec<?> codec = processors[key].codec;

        MemorySegment segment = midfEncoder.encode(arena, (Event<MIDFData>) event, (Codec<MIDFData>) codec);
        deliveryHandler.delivery(segment, event.getTarget());
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

    private <T extends MIDFData> void executeIntention(InnerProcessor<T> processor, MemorySegment segment, int originId) {
        Intention<T> intention = intentionDecoder.decode(segment, originId, processor.codec);

        if (processor.validator != null) {
            if (processor.validator.validate(intention) < 1) {
                return;
            }
        }

        if (processor.useCase != null) {
            processor.useCase.execute(intention.getData());
        }
    }
}
