package br.com.pietroth.tsa.core.engine.runtime;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import br.com.pietroth.tsa.core.engine.communication.event.Event;
import br.com.pietroth.tsa.core.engine.communication.event.EventDeliveryHandler;
import br.com.pietroth.tsa.core.engine.communication.intention.Intention;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionValidator;
import br.com.pietroth.tsa.core.engine.usecase.UseCase;

import java.lang.foreign.MemorySegment;

@SuppressWarnings("rawtypes")
public final class DataProcessingPipeline {
    private final UseCase[] usecases;
    private final IntentionValidator[] validators;
    private final Codec[] codecs;

    private final IntentionDecoder intentionDecoder;
    private final EventDeliveryHandler deliveryHandler;

    public DataProcessingPipeline(IntentionDecoder intentionDecoder, EventDeliveryHandler deliveryHandler) {
        this.intentionDecoder = intentionDecoder;
        this.deliveryHandler = deliveryHandler;

        usecases = new UseCase[4096];
        validators = new IntentionValidator[4096];
        codecs = new Codec[4096];
    }

    public void register(
        int family, 
        int type, 
        IntentionValidator<? extends MIDFData> validator, 
        UseCase<? extends MIDFData> useCase, 
        Codec<? extends MIDFData> codec) 
    {
        int key = pack(family, type);
        validators[key] = validator;
        usecases[key] = useCase;
        codecs[key] = codec;
    }

    @SuppressWarnings("unchecked")
    public void processIntention(MemorySegment segment, int originId) {
        System.out.println("Gateway raw bytes: " + segment.byteSize()); // debug

        Intention<? extends MIDFData> intention = intentionDecoder.decode(segment, originId);
        
        System.out.println("Decoded intention family=" + (intention.getFamily() & 0xFF)
            + " type=" + (intention.getType() & 0xFF)
            + " data=" + intention.getData()); // debug

        int key = pack(intention.getFamily(), intention.getType());

        IntentionValidator<MIDFData> validator = (IntentionValidator<MIDFData>) validators[key];

        if (validator != null) {
            if (validator.validate((Intention) intention) < 1) {
                return;
            }
        }

        UseCase<MIDFData> useCase = (UseCase<MIDFData>) usecases[key];
        if (useCase != null) {
            useCase.execute(intention.getData());
        }
    }

    @SuppressWarnings("unchecked")
    public void processEvent(Event<? extends MIDFData> event) {
        int key = pack(event.getFamily(), event.getType());

        Codec<MIDFData> codec = (Codec<MIDFData>) codecs[key];
        if (codec != null) return;

        deliveryHandler.delivery(event, codec);
    }

    private static int pack(int family, int type) {
        if ((family & ~0x3F) != 0 || (type & ~0x3F) != 0) {
            throw new IllegalArgumentException("family/type out of range");
        }
        return ((family & 0x3F) << 6) | (type & 0x3F);
    }
}
