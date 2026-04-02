package br.com.pietroth.tsa.core;

import br.com.pietroth.tsa.core.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.ecs.component.PositionComponent;
import br.com.pietroth.tsa.core.ecs.component.VelocityComponent;
import br.com.pietroth.tsa.core.ecs.system.MovementSystem;
import br.com.pietroth.tsa.core.world.player.PlayerComponent;
import br.com.pietroth.tsa.core.event.*;
import br.com.pietroth.tsa.core.event.codec.CodecRegistry;
import br.com.pietroth.tsa.core.event.codec.Codecs;
import br.com.pietroth.tsa.core.event.player.PlayerEvents;
import br.com.pietroth.tsa.core.event.player.playermoved.PlayerMovedExecuter;
import br.com.pietroth.tsa.core.application.MovementUseCase;

public class GameLoop extends TicksPerSecondRunnable {

    private final ECSRuntime ecsRuntime;
    private final CodecRegistry registry;
    private final GameConfiguration configuration;

    private EventDispatcher dispatcher;

    private GameLoop(Builder builder) {
        super(30);
        this.ecsRuntime = builder.ecsRuntime;
        this.registry = builder.registry;
        this.configuration = builder.configuration;
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
            (byte) EventIdentifier.Player.getGlobalId(),
            (byte) EventIdentifier.Player.PLAYER_MOVED.getId(),
            new PlayerMovedExecuter(new MovementUseCase(ecsRuntime.getContainer()))
        );
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ECSRuntime ecsRuntime;
        private CodecRegistry registry;
        private GameConfiguration configuration;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public Builder registry(CodecRegistry registry) {
            this.registry = registry;
            return this;
        }

        public Builder configuration(GameConfiguration configuration) {
            this.configuration = configuration;
            return this;
        }

        public GameLoop build() {
            if (ecsRuntime == null) throw new IllegalStateException("ECSRuntime is required");
            if (registry == null) throw new IllegalStateException("CodecRegistry is required");
            if (configuration == null) throw new IllegalStateException("GameConfiguration is required");
            return new GameLoop(this);
        }
    }
}