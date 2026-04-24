package br.com.pietroth.tsa.core.game;

import java.time.Duration;
import java.util.concurrent.Executors;

import br.com.pietroth.tsa.core.engine.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.engine.TicksPerSecondRunnable;
import br.com.pietroth.tsa.core.engine.communication.MIDFEncoder;
import br.com.pietroth.tsa.core.engine.communication.codec.CodecRegistry;
import br.com.pietroth.tsa.core.engine.communication.event.*;
import br.com.pietroth.tsa.core.engine.communication.event.target.TargetScope;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManagerSingleton;
import br.com.pietroth.tsa.core.engine.network.transport.Server;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;
import br.com.pietroth.tsa.core.game.ecs.component.PositionComponent;
import br.com.pietroth.tsa.core.game.ecs.component.VelocityComponent;
import br.com.pietroth.tsa.core.game.ecs.system.MovementSystem;
import br.com.pietroth.tsa.core.game.player.PlayerComponent;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveData;
import br.com.pietroth.tsa.infrastructure.network.tcp.TCPServer;

public class GameLoop extends TicksPerSecondRunnable {
    private final ECSRuntime ecsRuntime;
    private final CodecRegistry codecRegistry;
    private final MIDFEncoder midfEncoder;
    private final EventPublisher eventPublisher;
    private final EventDeliveryHandler eventDeliveryHandler;
    private Server server;

    private GameLoop(Builder builder) {
        super(20);
        this.ecsRuntime = builder.ecsRuntime;
        this.codecRegistry = builder.codecRegistry;
        this.midfEncoder = new MIDFEncoder(codecRegistry);
        this.eventDeliveryHandler = new EventDeliveryHandler(midfEncoder);
        this.eventPublisher = new EventPublisher(eventDeliveryHandler);
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
        server.subscribe(ClientLCManagerSingleton.get());
        new Thread(server).start();
    }

    @Override
    protected void tick() {
        ecsRuntime.tick();
    }

    private void scheduleSystems() {
        ecsRuntime.schedule(new MovementSystem(ecsRuntime.getContainer()));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ECSRuntime ecsRuntime;
        private CodecRegistry codecRegistry;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public Builder codecRegistry(CodecRegistry codecRegistry) {
            this.codecRegistry = codecRegistry;
            return this;
        }

        public GameLoop build() {
            if (ecsRuntime == null) {
                throw new IllegalStateException("ECSRuntime must be provided");
            }

            if (codecRegistry == null) {
                throw new IllegalStateException("CodecRegistry must be provided");
            }

            return new GameLoop(this);
        }
    }
}