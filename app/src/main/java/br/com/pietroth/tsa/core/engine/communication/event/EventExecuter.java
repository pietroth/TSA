package br.com.pietroth.tsa.core.engine.communication.event;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public interface EventExecuter<T extends MIDFData> {
    void execute(T event);
}
