package br.com.pietroth.tsa.core.game.physics.movement;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.engine.usecase.UseCase;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveData;

public class MoveUseCase implements UseCase<PlayerMoveData> {
    private final ECSContainer container;

    public MoveUseCase(ECSContainer container) {
        this.container = container;
    }

    @Override
    public void execute(PlayerMoveData data) {
        container.forEachEntityWith(new Class[]{VelocityComponent.class, PositionComponent.class}, entity -> {
            VelocityComponent velocity = entity.get(VelocityComponent.class);
            velocity.x += data.sx;
            velocity.y += data.sy;
        });
    }
}
