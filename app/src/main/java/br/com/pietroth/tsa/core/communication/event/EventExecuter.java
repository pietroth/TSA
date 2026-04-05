package br.com.pietroth.tsa.core.communication.event;

import br.com.pietroth.tsa.core.communication.MessageData;

public interface EventExecuter<T extends MessageData> {
    void execute(T event);
}
