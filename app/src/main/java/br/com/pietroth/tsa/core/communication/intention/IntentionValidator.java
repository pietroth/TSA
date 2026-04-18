package br.com.pietroth.tsa.core.communication.intention;

import br.com.pietroth.tsa.core.communication.MIDFData;

public interface IntentionValidator<T extends MIDFData> {
    int validate(Intention<T> intention);
}
