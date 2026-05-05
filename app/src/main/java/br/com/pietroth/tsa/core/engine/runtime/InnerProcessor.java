package br.com.pietroth.tsa.core.engine.runtime;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import br.com.pietroth.tsa.core.engine.communication.validator.Validator;
import br.com.pietroth.tsa.core.engine.usecase.UseCase;

public record InnerProcessor<T extends MIDFData>(
    Validator<T> validator,
    UseCase<T> useCase,
    Codec<T> codec
) {}
