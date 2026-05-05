package br.com.pietroth.tsa.core.engine.runtime;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import br.com.pietroth.tsa.core.engine.communication.validator.Validator;
import br.com.pietroth.tsa.core.engine.usecase.UseCase;

@SuppressWarnings("rawtypes")
public final class ComponentResolver {
    private final InnerProcessor[] processors = new InnerProcessor[4096];

    public <T extends MIDFData> void register(
        int family,
        int type,
        Validator<T> validator,
        UseCase<T> useCase,
        Codec<T> codec)
    {
        processors[pack(family, type)] = new InnerProcessor<>(validator, useCase, codec);
    }

    public InnerProcessor<?> lookup(int family, int type) {
        return processors[pack(family, type)];
    }

    private static int pack(int family, int type) {
        if ((family & ~0x3F) != 0 || (type & ~0x3F) != 0) {
            throw new IllegalArgumentException("family/type out of range");
        }
        return ((family & 0x3F) << 6) | (type & 0x3F);
    }

}
