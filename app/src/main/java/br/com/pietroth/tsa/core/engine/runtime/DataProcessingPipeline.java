package br.com.pietroth.tsa.core.engine.runtime;

import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionValidator;
import br.com.pietroth.tsa.core.engine.usecase.UseCase;

@SuppressWarnings("rawtypes")
public final class ComponentResolver {
    private final UseCase[] usecases;
    private final IntentionValidator[] validators;
    private final Codec[] codecs;

    public ComponentResolver() {
        usecases = new UseCase[4096];
        validators = new IntentionValidator[4096];
        codecs = new Codec[4096];
    }

    public void registerValidator(int family, int type, IntentionValidator validator) {
        int key = pack(family, type);
        validators[key] = validator;
    }

    public void registerUseCase(int family, int type, UseCase useCase) {
        int key = pack(family, type);
        usecases[key] = useCase;
    }

    public void registerCodec(int family, int type, Codec codec) {
        int key = pack(family, type);
        codecs[key] = codec;
    }

    private static int pack(int family, int type) {
        if ((family & ~0x3F) != 0 || (type & ~0x3F) != 0) {
            throw new IllegalArgumentException("family/type out of range");
        }
        return ((family & 0x3F) << 6) | (type & 0x3F);
    }
}
