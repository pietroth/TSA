package br.com.pietroth.tsa.core.engine.application.player;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.engine.ecs.component.VelocityComponent;
import br.com.pietroth.tsa.core.engine.world.player.PlayerComponent;

public class PlayerMovementUseCase {
    private final ECSContainer container;

    public PlayerMovementUseCase(ECSContainer container) {
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
