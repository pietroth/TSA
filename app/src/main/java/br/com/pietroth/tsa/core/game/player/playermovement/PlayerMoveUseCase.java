package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.engine.usecase.UseCase;
import br.com.pietroth.tsa.core.game.physics.movement.VelocityComponent;
import br.com.pietroth.tsa.core.game.player.PlayerComponent;

public class PlayerMoveUseCase implements UseCase<PlayerMoveData> {
    private final ECSContainer container;

    public PlayerMoveUseCase(ECSContainer container) {
        this.container = container;
    }

    public void execute(PlayerMoveData data) {
        container.forEachEntityWith(new Class[]{PlayerComponent.class, VelocityComponent.class}, entity -> {
            PlayerComponent player = entity.get(PlayerComponent.class);
            VelocityComponent velocity = entity.get(VelocityComponent.class);

            if (player.id == data.playerId) {
                velocity.x += data.sx;
                velocity.y += data.sy;
            }
        });
    }
}
