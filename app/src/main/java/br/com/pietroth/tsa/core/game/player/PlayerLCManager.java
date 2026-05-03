package br.com.pietroth.tsa.core.game.player;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.engine.ecs.entity.ECSEntity;
import br.com.pietroth.tsa.core.engine.network.protocol.ConnectionProcessedListener;
import br.com.pietroth.tsa.core.engine.network.transport.Connection;
import br.com.pietroth.tsa.core.game.physics.movement.PositionComponent;
import br.com.pietroth.tsa.core.game.physics.movement.VelocityComponent;

// LC = LifeCycle.

public class PlayerLCManager implements ConnectionProcessedListener {
    private final Player2EntityResolver resolver;
    private final ECSContainer container;

    public PlayerLCManager(Player2EntityResolver resolver, ECSContainer container) {
        this.resolver = resolver;
        this.container = container;
    }

    @Override
    public void onConnectionProcessed(Connection connection) {
        ECSEntity player = container.createEntity(
            new PlayerComponent(),
            new PositionComponent(0, 0),
            new VelocityComponent(0, 0)
        );

        resolver.bind(connection.getId(), player.getId());
    }
    
}
