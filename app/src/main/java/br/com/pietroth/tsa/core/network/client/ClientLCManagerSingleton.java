package br.com.pietroth.tsa.core.network.client;

import br.com.pietroth.tsa.core.network.protocol.IntentionGateway;

public class ClientLCManagerSingleton {
    private static ClientLCManager instance;

    public static void init(int maxClients, IntentionGateway intentionGateway) {
        if (instance != null) {
            throw new IllegalStateException("Já inicializado");
        }
        instance = new ClientLCManager(maxClients, intentionGateway);
    }

    public static ClientLCManager get() {
        if (instance == null) {
            throw new IllegalStateException("Não inicializado");
        }
        return instance;
    }
}
