package br.com.pietroth.tsa.core.engine.communication.intention;

import java.util.HashMap;

public class IntentionVDSingleton {
    private static IntentionVD instance;

    public static void init() {
        if (instance != null) {
            throw new IllegalStateException("IntentionVDSingleton is already initialized");
        }
        instance = new IntentionVD(new HashMap<>());
    }

    public static IntentionVD get() {
        if (instance == null) {
            throw new IllegalStateException("IntentionVDSingleton is not initialized");
        }
        return instance;
    }
}
