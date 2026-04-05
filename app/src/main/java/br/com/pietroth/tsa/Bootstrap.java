package br.com.pietroth.tsa;

import br.com.pietroth.tsa.core.communication.event.EventDispatcher;
import br.com.pietroth.tsa.core.communication.event.Executers;
import br.com.pietroth.tsa.core.communication.codec.CodecRegistry;
import br.com.pietroth.tsa.core.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.GameLoop;
import br.com.pietroth.tsa.core.application.MovementUseCase;
import br.com.pietroth.tsa.core.communication.codec.Codecs;
import br.com.pietroth.tsa.core.communication.event.player.playermoved.PlayerMovedExecuter;
import br.com.pietroth.tsa.core.communication.player.playermovement.PlayerMoveCodec;

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
        Codecs codecs = new Codecs.Builder()
            .playerMovementCodec(new PlayerMoveCodec())
            .build();
        codecs.registerCodecs(registry);
        Executers executers = new Executers.Builder()
            .playerMovedExecuter(new PlayerMovedExecuter(new MovementUseCase(ecsRuntime.getContainer())))
            .build();
        executers.registerExecuters(dispatcher);

        GameLoop loop = GameLoop.builder()
            .ecsRuntime(ecsRuntime)
            .eventDispatcher(dispatcher)
            .build();
        new Thread(loop).start();
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
