package br.com.pietroth.tsa.core.engine.communication.response;

public class IRPublisherSingleton {
    private static IRPublisher instance;

    public static void init(IRPublisher irPublisher) {
        if (instance != null) {
            throw new IllegalStateException("IRPublisherSingleton is already initialized");
        }
        instance = irPublisher;
    }

    public static IRPublisher get() {
        if (instance == null) {
            throw new IllegalStateException("IRPublisherSingleton is not initialized");
        }
        return instance;
    }
}
