package br.com.pietroth.tsa.core.game.physics.movement;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.engine.usecase.UseCase;

public class MoveUseCase implements UseCase<MoveData> {
    private final ECSContainer container;

    public MoveUseCase(ECSContainer container) {
        this.container = container;
    }

    @Override
    public void execute(int entityId, MoveData data) {
        container.forEachEntityWith(new Class[]{VelocityComponent.class, PositionComponent.class}, entity -> {
            VelocityComponent velocity = entity.getComponent(VelocityComponent.class);
            velocity.x += data.sx;
            velocity.y += data.sy;
        });
    }
}
