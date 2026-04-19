package br.com.pietroth.tsa.core.game.ecs.system;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.game.ecs.component.PositionComponent;
import br.com.pietroth.tsa.core.game.ecs.component.VelocityComponent;

public class MovementSystem implements Runnable {
    private final ECSContainer container;

    private float lastX;
    private float lastY;

    public MovementSystem(ECSContainer container) {
        this.container = container;
        this.lastX = 0;
        this.lastY = 0;
    }

    @Override
    public void run() {
        container.forEachEntityWith(new Class[]{PositionComponent.class, VelocityComponent.class}, entity -> {
            PositionComponent position = entity.get(PositionComponent.class);
            VelocityComponent velocity = entity.get(VelocityComponent.class);

            this.lastX = position.x;
            this.lastY = position.y;

            position.x += velocity.x;
            position.y += velocity.y;

                velocity.x = 0;
                velocity.y = 0;

                if (lastX != position.x || lastY != position.y) {
                    System.out.println("" + position.x + ", " + position.y);
                }
            });
    }
}