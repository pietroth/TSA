package br.com.pietroth.tsa.core.communication.event;

import br.com.pietroth.tsa.core.communication.MIDFData;

public interface EventExecuter<T extends MIDFData> {
    void execute(T event);
}
