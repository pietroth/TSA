package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.game.ecs.component.VelocityComponent;
import br.com.pietroth.tsa.core.game.player.PlayerComponent;

public class PlayerMoveUseCase {
    private final ECSContainer container;

    public PlayerMoveUseCase(ECSContainer container) {
        this.container = container;
    }

    public void execute(int playerId, float sx, float sy) {
        container.forEachEntityWith(new Class[]{PlayerComponent.class, VelocityComponent.class}, entity -> {
            PlayerComponent player = entity.get(PlayerComponent.class);
            VelocityComponent velocity = entity.get(VelocityComponent.class);

            if (player.id == playerId) {
                velocity.x += sx;
                velocity.y += sy;
            }
        });
    }
}
