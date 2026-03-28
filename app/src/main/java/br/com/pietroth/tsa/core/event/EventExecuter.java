package br.com.pietroth.tsa.core.event;

public interface EventExecuter<T extends EventData> {
    void execute(T event);
}
