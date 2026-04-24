package br.com.pietroth.tsa;

import br.com.pietroth.tsa.core.engine.communication.event.EventDeliveryHandler;
import br.com.pietroth.tsa.core.engine.communication.event.EventPublisherSingleton;
import br.com.pietroth.tsa.core.engine.communication.MIDFEncoder;
import br.com.pietroth.tsa.core.engine.communication.codec.CodecRegistry;
import br.com.pietroth.tsa.core.engine.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManagerSingleton;
import br.com.pietroth.tsa.core.engine.network.protocol.IntentionGateway;
import br.com.pietroth.tsa.core.game.Codecs;
import br.com.pietroth.tsa.core.game.GameLoop;
import br.com.pietroth.tsa.core.game.Validators;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveCodec;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveValidator;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionVDSingleton;

public class Bootstrap {
    private final ECSRuntime ecsRuntime;
    private final CodecRegistry registry;

    public Bootstrap(Builder builder) {
        this.ecsRuntime = builder.ecsRuntime;
        this.registry = builder.registry;
    }

    public void boot() {
        Codecs.registerAll(
            registry, 
            new PlayerMoveCodec()
        );

        EventPublisherSingleton.init(new EventDeliveryHandler(new MIDFEncoder(registry)));
        IntentionVDSingleton.init();

        ClientLCManagerSingleton.init(
            10, new IntentionGateway(new IntentionDecoder(registry)));

        Validators validators = new Validators.Builder()
            .intentionVD(IntentionVDSingleton.get())
            .playerMoveValidator(new PlayerMoveValidator())
            .build();
        validators.registerValidators();

        // GameLoop builder

        GameLoop loop = GameLoop.builder()
            .ecsRuntime(ecsRuntime)
            .build();
        new Thread(loop).start();
    }

    public static class Builder {
        private ECSRuntime ecsRuntime;
        private CodecRegistry registry;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public Builder codecRegistry(CodecRegistry registry) {
            this.registry = registry;
            return this;
        }

        public Bootstrap build() {
            if (ecsRuntime == null) throw new IllegalStateException("ECSRuntime is required");
            if (registry == null) throw new IllegalStateException("CodecRegistry is required");
            return new Bootstrap(this);
        }
    }
}
