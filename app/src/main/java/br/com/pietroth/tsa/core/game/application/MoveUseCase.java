package br.com.pietroth.tsa.core.game.application;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.game.ecs.component.PositionComponent;
import br.com.pietroth.tsa.core.game.ecs.component.VelocityComponent;

public class MoveUseCase {
    private final ECSContainer container;

    public MoveUseCase(ECSContainer container) {
        this.container = container;
    }

    public void execute(float sx, float sy) {
        container.forEachEntityWith(new Class[]{VelocityComponent.class, PositionComponent.class}, entity -> {
            VelocityComponent velocity = entity.get(VelocityComponent.class);
            velocity.x += sx;
            velocity.y += sy;
        });
    }
}
