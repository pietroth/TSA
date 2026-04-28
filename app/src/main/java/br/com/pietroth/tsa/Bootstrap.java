package br.com.pietroth.tsa;

import br.com.pietroth.tsa.core.engine.communication.event.EventPublisherSingleton;
import br.com.pietroth.tsa.core.engine.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManagerSingleton;
import br.com.pietroth.tsa.core.engine.network.protocol.IntentionGateway;
import br.com.pietroth.tsa.core.engine.runtime.DataProcessingPipeline;
import br.com.pietroth.tsa.core.game.GameLoop;
import br.com.pietroth.tsa.core.game.world.block.BlockRegister;
import br.com.pietroth.tsa.core.game.world.block.Blocks;

public class Bootstrap {
    private final ECSRuntime ecsRuntime;
    private final BlockRegister blockRegister;
    private final DataProcessingPipeline dataProcessingPipeline;

    public Bootstrap(Builder builder) {
        this.ecsRuntime = builder.ecsRuntime;
        this.blockRegister = builder.blockRegister;
        this.dataProcessingPipeline = builder.dataProcessingPipeline;
    }

    public void boot() {

        EventPublisherSingleton.init(dataProcessingPipeline);

        ClientLCManagerSingleton.init(
            10, new IntentionGateway(dataProcessingPipeline));

        Blocks.registerAll(blockRegister);

        // GameLoop builder

        GameLoop loop = GameLoop.builder()
            .ecsRuntime(ecsRuntime)
            .build();
        new Thread(loop).start();
    }

    public static class Builder {
        private ECSRuntime ecsRuntime;
        private BlockRegister blockRegister;
        private DataProcessingPipeline dataProcessingPipeline;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public Builder blockRegister(BlockRegister blockRegister) {
            this.blockRegister = blockRegister;
            return this;
        }
        
        public Builder dataProcessingPipeline(DataProcessingPipeline dataProcessingPipeline) {
            this.dataProcessingPipeline = dataProcessingPipeline;
            return this;
        }

        public Bootstrap build() {
            if (ecsRuntime == null) throw new IllegalStateException("ECSRuntime is required");
            if (blockRegister == null) throw new IllegalStateException("BlockRegister is required");
            if (dataProcessingPipeline == null) throw new IllegalStateException("DataProcessingPipeline is required");
            return new Bootstrap(this);
        }
    }
}
