package br.com.pietroth.tsa.core;

import java.util.concurrent.Executors;

import br.com.pietroth.tsa.core.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.ecs.component.PositionComponent;
import br.com.pietroth.tsa.core.ecs.component.VelocityComponent;
import br.com.pietroth.tsa.core.ecs.system.MovementSystem;
import br.com.pietroth.tsa.core.world.player.PlayerComponent;
import br.com.pietroth.tsa.core.communication.event.*;
import br.com.pietroth.tsa.core.network.transport.Server;
import br.com.pietroth.tsa.core.network.transport.TCPServer;

public class GameLoop extends TicksPerSecondRunnable {
    private final ECSRuntime ecsRuntime;
    private Server server;

    private GameLoop(Builder builder) {
        super(30);
        this.ecsRuntime = builder.ecsRuntime;
    }

    @Override
    protected void initialize() {
        scheduleSystems();

        ecsRuntime.createEntity(
            new PlayerComponent(1),
            new PositionComponent(0, 0),
            new VelocityComponent(0, 0)
        );

        server = TCPServer.builder()
            .port(5555)
            .clientPool(Executors.newCachedThreadPool())
            .build();
        new Thread(server).start();
    }

    @Override
    protected void tick() {
        ecsRuntime.tick();
        EventDispatcherSingleton.get().run();

        ecsRuntime.getContainer().forEachEntityWith
            (new Class[]{PositionComponent.class, VelocityComponent.class}, entity -> {
                PositionComponent position = entity.get(PositionComponent.class);
                System.out.println("" + position.x + " ," + position.y);
            });
    }

    private void scheduleSystems() {
        ecsRuntime.schedule(new MovementSystem(ecsRuntime.getContainer()));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ECSRuntime ecsRuntime;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public GameLoop build() {
            if (ecsRuntime == null) {
                throw new IllegalStateException("ECSRuntime must be provided");
            }

            return new GameLoop(this);
        }
    }
}