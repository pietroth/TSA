package br.com.pietroth.tsa;

import br.com.pietroth.tsa.core.communication.MessageIdentifier;
import br.com.pietroth.tsa.core.communication.event.EventDispatcher;
import br.com.pietroth.tsa.core.communication.event.codec.CodecRegistry;
import br.com.pietroth.tsa.core.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.ecs.component.PositionComponent;
import br.com.pietroth.tsa.core.ecs.component.VelocityComponent;
import br.com.pietroth.tsa.core.ecs.system.MovementSystem;
import br.com.pietroth.tsa.core.world.player.PlayerComponent;
import br.com.pietroth.tsa.core.GameLoop;
import br.com.pietroth.tsa.core.application.MovementUseCase;
import br.com.pietroth.tsa.core.communication.event.codec.Codecs;
import br.com.pietroth.tsa.core.communication.event.player.playermoved.PlayerMovedExecuter;
import br.com.pietroth.tsa.core.communication.intention.IntentionVDSingleton;

public class Bootstrap {
    private final ECSRuntime ecsRuntime;
    private final CodecRegistry registry;
    private EventDispatcher dispatcher;

    public Bootstrap(Builder builder) {
        this.ecsRuntime = builder.ecsRuntime;
        this.registry = builder.registry;
        this.dispatcher = builder.dispatcher;
    }

    public void boot() {
        registerCodecs(registry);
        registerExecuters(dispatcher);

        GameLoop loop = GameLoop.builder()
            .ecsRuntime(ecsRuntime)
            .eventDispatcher(dispatcher)
            .build();
        new Thread(loop).start();
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

    public static class Builder {
        private ECSRuntime ecsRuntime;
        private CodecRegistry registry;
        private EventDispatcher dispatcher;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public Builder codecRegistry(CodecRegistry registry) {
            this.registry = registry;
            return this;
        }

        public Builder eventDispatcher(EventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }

        public Bootstrap build() {
            if (ecsRuntime == null) throw new IllegalStateException("ECSRuntime is required");
            if (registry == null) throw new IllegalStateException("CodecRegistry is required");
            if (dispatcher == null) throw new IllegalStateException("EventDispatcher is required");
            return new Bootstrap(this);
        }
    }
}
