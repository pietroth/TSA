package br.com.pietroth.tsa.core.communication.intention;

import br.com.pietroth.tsa.core.communication.MessageData;

public interface IntentionValidator<T extends MessageData> {
    boolean validate(Intention<T> intention);
}
