package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.engine.ecs.entity.ECSEntity;
import br.com.pietroth.tsa.core.engine.usecase.UseCase;
import br.com.pietroth.tsa.core.game.physics.movement.VelocityComponent;
import br.com.pietroth.tsa.core.game.player.PlayerComponent;

public class PlayerMoveUseCase implements UseCase<PlayerMoveData> {
    private final ECSContainer container;

    public PlayerMoveUseCase(ECSContainer container) {
        this.container = container;
    }

    public void execute(PlayerMoveData data) {
        ECSEntity entity = container.getEntity(data.playerId);
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
