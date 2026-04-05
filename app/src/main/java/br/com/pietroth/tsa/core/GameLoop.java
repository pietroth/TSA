package br.com.pietroth.tsa.core;

import br.com.pietroth.tsa.core.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.ecs.component.PositionComponent;
import br.com.pietroth.tsa.core.ecs.component.VelocityComponent;
import br.com.pietroth.tsa.core.ecs.system.MovementSystem;
import br.com.pietroth.tsa.core.world.player.PlayerComponent;
import br.com.pietroth.tsa.core.application.MovementUseCase;
import br.com.pietroth.tsa.core.communication.MessageIdentifier;
import br.com.pietroth.tsa.core.communication.event.*;
import br.com.pietroth.tsa.core.communication.event.codec.CodecRegistry;
import br.com.pietroth.tsa.core.communication.event.codec.Codecs;
import br.com.pietroth.tsa.core.communication.event.player.PlayerEvents;
import br.com.pietroth.tsa.core.communication.event.player.playermoved.PlayerMovedExecuter;

public class GameLoop extends TicksPerSecondRunnable {

    private final ECSRuntime ecsRuntime;
    private final CodecRegistry registry;

    private EventDispatcher dispatcher;

    private GameLoop(Builder builder) {
        super(30);
        this.ecsRuntime = builder.ecsRuntime;
        this.registry = builder.registry;
    }

    @Override
    protected void initialize() {
        registerCodecs(registry);

        ecsRuntime.createEntity(
            new PlayerComponent(1),
            new PositionComponent(0, 0),
            new VelocityComponent(0, 0)
        );

        dispatcher = new EventDispatcher(256, 256);
        registerExecuters(dispatcher);

        PlayerEvents playerEvents = new PlayerEvents(dispatcher);

        ecsRuntime.schedule(new MovementSystem(ecsRuntime.getContainer()));

        playerEvents.publish_PlayerMoved(5f, 0f);

        dispatcher.run();
    }

    @Override
    protected void tick() {
        ecsRuntime.tick();
        dispatcher.run();
    }

    private void registerCodecs(CodecRegistry registry) {
        Codecs.registerCodecs(registry);
    }

    private void registerExecuters(EventDispatcher dispatcher) {
        dispatcher.register(
            (byte) MessageIdentifier.Player.getGlobalId(),
            (byte) MessageIdentifier.Player.PLAYER_MOVED.getId(),
            new PlayerMovedExecuter(new MovementUseCase(ecsRuntime.getContainer()))
        );
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ECSRuntime ecsRuntime;
        private CodecRegistry registry;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public Builder registry(CodecRegistry registry) {
            this.registry = registry;
            return this;
        }

        public GameLoop build() {
            if (ecsRuntime == null) throw new IllegalStateException("ECSRuntime is required");
            if (registry == null) throw new IllegalStateException("CodecRegistry is required");
            return new GameLoop(this);
        }
    }
}