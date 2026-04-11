package br.com.pietroth.tsa.core;

import java.util.concurrent.Executors;

import br.com.pietroth.tsa.core.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.ecs.component.PositionComponent;
import br.com.pietroth.tsa.core.ecs.component.VelocityComponent;
import br.com.pietroth.tsa.core.ecs.system.MovementSystem;
import br.com.pietroth.tsa.core.world.player.PlayerComponent;
import br.com.pietroth.tsa.core.communication.codec.CodecRegistry;
import br.com.pietroth.tsa.core.communication.event.*;
import br.com.pietroth.tsa.core.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.communication.intention.IntentionVDSingleton;
import br.com.pietroth.tsa.core.network.client.ClientLCManagerSingleton;
import br.com.pietroth.tsa.core.network.protocol.IntentionGateway;
import br.com.pietroth.tsa.core.network.transport.Server;
import br.com.pietroth.tsa.core.network.transport.TCPServer;

public class GameLoop extends TicksPerSecondRunnable {
    private final ECSRuntime ecsRuntime;
    private EventDispatcher dispatcher;
    private Server server;

    private GameLoop(Builder builder) {
        super(30);
        this.ecsRuntime = builder.ecsRuntime;
        this.dispatcher = builder.dispatcher;
    }

    @Override
    protected void initialize() {
        scheduleSystems();

        ecsRuntime.createEntity(
            new PlayerComponent(1),
            new PositionComponent(0, 0),
            new VelocityComponent(0, 0)
        );

        IntentionVDSingleton.initialize();

        server = TCPServer.builder()
            .port(5555)
            .clientPool(Executors.newCachedThreadPool())
            .build();

        IntentionGateway intentionGateway = new IntentionGateway(new IntentionDecoder(new CodecRegistry()), dispatcher);
        ClientLCManagerSingleton.init(10, intentionGateway);
    }

    @Override
    protected void tick() {
        ecsRuntime.tick();
        dispatcher.run();
        server.run();
    }

    private void scheduleSystems() {
        ecsRuntime.schedule(new MovementSystem(ecsRuntime.getContainer()));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ECSRuntime ecsRuntime;
        private EventDispatcher dispatcher;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public Builder eventDispatcher(EventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }

        public GameLoop build() {
            if (ecsRuntime == null) {
                throw new IllegalStateException("ECSRuntime must be provided");
            }
            if (dispatcher == null) {
                throw new IllegalStateException("EventDispatcher must be provided");
            }
            return new GameLoop(this);
        }
    }
}