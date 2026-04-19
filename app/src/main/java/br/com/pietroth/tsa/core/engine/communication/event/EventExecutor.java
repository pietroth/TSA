package br.com.pietroth.tsa.core.engine.communication.event;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public interface EventExecutor<T extends MIDFData> {
    void execute(T event);
}
