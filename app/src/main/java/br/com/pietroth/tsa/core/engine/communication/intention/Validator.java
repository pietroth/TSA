package br.com.pietroth.tsa.core.engine.communication.intention;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

@FunctionalInterface
public interface IntentionValidator<T extends MIDFData> {
    int validate(Intention<T> intention);
}
