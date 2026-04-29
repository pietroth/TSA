package br.com.pietroth.tsa.core.engine.communication.event;

import br.com.pietroth.tsa.core.engine.runtime.DataProcessingPipeline;

public class EventPublisherSingleton {
    private static EventPublisher instance;

    public static void init(DataProcessingPipeline processingPipeline) {
        if (instance != null) {
            throw new IllegalStateException("EventPublisherSingleton is already initialized");
        }
        instance = new EventPublisher(processingPipeline);
    }

    public static EventPublisher get() {
        if (instance == null) {
            throw new IllegalStateException("EventPublisherSingleton is not initialized");
        }
        return instance;
    }
}
