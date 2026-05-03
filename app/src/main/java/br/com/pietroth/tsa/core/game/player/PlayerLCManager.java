package br.com.pietroth.tsa.core.game.player;

import br.com.pietroth.tsa.core.engine.network.protocol.ConnectionProcessedListener;
import br.com.pietroth.tsa.core.engine.network.transport.Connection;

// LC = LifeCycle.

public class PlayerLCManager implements ConnectionProcessedListener {
    private final Player2EntityResolver resolver;

    public PlayerLCManager(Player2EntityResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public void onConnectionProcessed(Connection connection) {
        resolver.bind(connection.getId(), 0);
    }
    
}
