package br.com.pietroth.tsa;

import br.com.pietroth.tsa.core.engine.communication.event.EventDeliveryHandler;
import br.com.pietroth.tsa.core.engine.communication.event.EventPublisherSingleton;
import br.com.pietroth.tsa.core.engine.communication.MIDFEncoder;
import br.com.pietroth.tsa.core.engine.communication.codec.CodecRegistry;
import br.com.pietroth.tsa.core.engine.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManagerSingleton;
import br.com.pietroth.tsa.core.engine.network.protocol.IntentionGateway;
import br.com.pietroth.tsa.core.engine.usecase.UseCaseRouter;
import br.com.pietroth.tsa.core.game.Codecs;
import br.com.pietroth.tsa.core.game.GameLoop;
import br.com.pietroth.tsa.core.game.Validators;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveCodec;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveValidator;
import br.com.pietroth.tsa.core.game.world.block.BlockRegister;
import br.com.pietroth.tsa.core.game.world.block.Blocks;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionVDSingleton;

public class Bootstrap {
    private final ECSRuntime ecsRuntime;
    private final CodecRegistry codecRegistry;
    private final BlockRegister blockRegister;
    private final UseCaseRouter useCaseRouter;

    public Bootstrap(Builder builder) {
        this.ecsRuntime = builder.ecsRuntime;
        this.codecRegistry = builder.codecRegistry;
        this.blockRegister = builder.blockRegister;
        this.useCaseRouter = builder.useCaseRouter;
    }

    public void boot() {
        Codecs.registerAll(
            codecRegistry, 
            new PlayerMoveCodec()
        );

        EventPublisherSingleton.init(new EventDeliveryHandler(new MIDFEncoder(codecRegistry)));
        IntentionVDSingleton.init();

        ClientLCManagerSingleton.init(
            10, new IntentionGateway(new IntentionDecoder(codecRegistry), useCaseRouter));

        Validators.registerAll(
            IntentionVDSingleton.get(),
            new PlayerMoveValidator() 
        );

        Blocks.registerAll(blockRegister);

        // GameLoop builder

        GameLoop loop = GameLoop.builder()
            .ecsRuntime(ecsRuntime)
            .build();
        new Thread(loop).start();
    }

    public static class Builder {
        private ECSRuntime ecsRuntime;
        private CodecRegistry codecRegistry;
        private BlockRegister blockRegister;
        private UseCaseRouter useCaseRouter;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public Builder codecRegistry(CodecRegistry codecRegistry) {
            this.codecRegistry = codecRegistry;
            return this;
        }

        public Builder blockRegister(BlockRegister blockRegister) {
            this.blockRegister = blockRegister;
            return this;
        }
        
        public Builder useCaseRouter(UseCaseRouter useCaseRouter) {
            this.useCaseRouter = useCaseRouter;
            return this;
        }

        public Bootstrap build() {
            if (ecsRuntime == null) throw new IllegalStateException("ECSRuntime is required");
            if (codecRegistry == null) throw new IllegalStateException("CodecRegistry is required");
            if (blockRegister == null) throw new IllegalStateException("BlockRegister is required");
            if (useCaseRouter == null) throw new IllegalStateException("UseCaseRouter is required");
            return new Bootstrap(this);
        }
    }
}
