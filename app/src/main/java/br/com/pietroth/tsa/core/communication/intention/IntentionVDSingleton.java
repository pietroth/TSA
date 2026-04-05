package br.com.pietroth.tsa.core.communication.intention;

import java.util.HashMap;

public enum IntentionVDSingleton {
    INSTANCE;

    private final IntentionVD intentionVD;

    IntentionVDSingleton() {
        this.intentionVD = new IntentionVD(new HashMap<>());
    }

    public IntentionVD getIntentionVD() {
        return intentionVD;
    }
}
