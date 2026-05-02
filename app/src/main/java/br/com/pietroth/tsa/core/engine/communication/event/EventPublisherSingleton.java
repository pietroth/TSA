package br.com.pietroth.tsa.core.engine.communication.event;

public class EventPublisherSingleton {
    private static EventPublisher instance;

    public static void init(EventPublisher publisher) {
        if (instance != null) {
            throw new IllegalStateException("EventPublisherSingleton is already initialized");
        }
        instance = publisher;
    }

    public static EventPublisher get() {
        if (instance == null) {
            throw new IllegalStateException("EventPublisherSingleton is not initialized");
        }
        return instance;
    }
}
