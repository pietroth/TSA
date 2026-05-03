package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.engine.ecs.entity.ECSEntity;
import br.com.pietroth.tsa.core.engine.usecase.UseCase;
import br.com.pietroth.tsa.core.game.physics.movement.VelocityComponent;
import br.com.pietroth.tsa.core.game.player.Player2EntityResolver;
import br.com.pietroth.tsa.core.game.player.PlayerComponent;

public class PlayerMoveUseCase implements UseCase<PlayerMoveData> {
    private final ECSContainer container;
    private final Player2EntityResolver resolver;

    public PlayerMoveUseCase(ECSContainer container, Player2EntityResolver resolver) {
        this.container = container;
        this.resolver = resolver;
    }
    @Override
    public void execute(int playerId, PlayerMoveData data) {
        int entityId = resolver.resolve(playerId);
        ECSEntity entity = container.getEntity(entityId);
        if (entity != null) {
            PlayerComponent player = entity.getComponent(PlayerComponent.class);
            VelocityComponent velocity = entity.getComponent(VelocityComponent.class);

            if (player != null && velocity != null) {
                velocity.x += data.sx;
                velocity.y += data.sy;
            }
        }
    }
}
