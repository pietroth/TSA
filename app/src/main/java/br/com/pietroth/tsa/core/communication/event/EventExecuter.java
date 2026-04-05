package br.com.pietroth.tsa.core.communication.event;

public interface EventExecuter<T extends EventData> {
    void execute(T event);
}
