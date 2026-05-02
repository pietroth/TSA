package br.com.pietroth.tsa.core.engine.network;

public class NetworkAggregatorSingleton {
    private static NetworkAggregator instance;

        public static void init(NetworkAggregator networkAggregator) {
        if (instance != null) {
            throw new IllegalStateException("NetworkAggregatorSingleton is already initialized");
        }
        instance = networkAggregator;
    }

    public static NetworkAggregator get() {
        if (instance == null) {
            throw new IllegalStateException("NetworkAggregatorSingleton is not initialized");
        }
        return instance;
    }
}
