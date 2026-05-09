package br.com.pietroth.tsa.core.engine.communication.validator;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.intention.Intention;

@FunctionalInterface
public interface Validator<T extends MIDFData> {
    ValidatorResponse validate(Intention<T> intention);
}
