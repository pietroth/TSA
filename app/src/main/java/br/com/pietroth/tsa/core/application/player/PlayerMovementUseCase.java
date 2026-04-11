package br.com.pietroth.tsa.core.application.player;

import br.com.pietroth.tsa.core.ecs.ECSContainer;
import br.com.pietroth.tsa.core.ecs.component.VelocityComponent;
import br.com.pietroth.tsa.core.world.player.PlayerComponent;

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
