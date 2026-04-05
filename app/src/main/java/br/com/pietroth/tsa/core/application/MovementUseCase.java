package br.com.pietroth.tsa.core.application;

import br.com.pietroth.tsa.core.ecs.ECSContainer;
import br.com.pietroth.tsa.core.ecs.component.PositionComponent;
import br.com.pietroth.tsa.core.ecs.component.VelocityComponent;

public class MovementUseCase {
    private final ECSContainer container;

    public MovementUseCase(ECSContainer container) {
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
