package br.com.pietroth.tsa.core.communication.event;

public class EventDispatcherSingleton {
    private static EventDispatcher instance;

    public static void init(int maxFamilies, int maxTypesPerFamily) {
        if (instance != null) {
            throw new IllegalStateException("EventDispatcherSingleton is already initialized");
        }
        instance = new EventDispatcher(maxFamilies, maxTypesPerFamily);
    }

    public static EventDispatcher get() {
        if (instance == null) {
            throw new IllegalStateException("EventDispatcherSingleton is not initialized");
        }
        return instance;
    }
}
