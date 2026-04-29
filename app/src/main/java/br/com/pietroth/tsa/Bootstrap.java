package br.com.pietroth.tsa;

import br.com.pietroth.tsa.core.engine.communication.event.EventPublisherSingleton;
import br.com.pietroth.tsa.core.engine.communication.response.IRPublisher;
import br.com.pietroth.tsa.core.engine.communication.response.IRPublisherSingleton;
import br.com.pietroth.tsa.core.engine.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManager;
import br.com.pietroth.tsa.core.engine.network.protocol.IntentionGateway;
import br.com.pietroth.tsa.core.engine.runtime.DataProcessingPipeline;
import br.com.pietroth.tsa.core.game.GameLoop;
import br.com.pietroth.tsa.core.game.communication.GameDataPipelineRegistrar;
import br.com.pietroth.tsa.core.game.world.block.BlockRegister;
import br.com.pietroth.tsa.core.game.world.block.Blocks;

public class Bootstrap {
    private final ECSRuntime ecsRuntime;
    private final BlockRegister blockRegister;
    private final DataProcessingPipeline dataProcessingPipeline;
    private final ClientLCManager clientLCManager;

    public Bootstrap(Builder builder) {
        this.ecsRuntime = builder.ecsRuntime;
        this.blockRegister = builder.blockRegister;
        this.dataProcessingPipeline = builder.dataProcessingPipeline;
        this.clientLCManager = builder.clientLCManager;
    }

    public void boot() {
        clientLCManager.setIntentionGateway(new IntentionGateway(dataProcessingPipeline));
            
        IRPublisherSingleton.init(new IRPublisher(dataProcessingPipeline));
        EventPublisherSingleton.init(dataProcessingPipeline);
        GameDataPipelineRegistrar.registerAll(dataProcessingPipeline, ecsRuntime);

        Blocks.registerAll(blockRegister);

        // GameLoop builder

        GameLoop loop = GameLoop.builder()
            .ecsRuntime(ecsRuntime)
            .clientLCManager(clientLCManager)
            .build();
        new Thread(loop).start();
    }

    public static class Builder {
        private ECSRuntime ecsRuntime;
        private BlockRegister blockRegister;
        private DataProcessingPipeline dataProcessingPipeline;
        private ClientLCManager clientLCManager;

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

        public Builder clientLCManager(ClientLCManager clientLCManager) {
            this.clientLCManager = clientLCManager;
            return this;
        }

        public Bootstrap build() {
            if (ecsRuntime == null) throw new IllegalStateException("ECSRuntime is required");
            if (blockRegister == null) throw new IllegalStateException("BlockRegister is required");
            if (dataProcessingPipeline == null) throw new IllegalStateException("DataProcessingPipeline is required");
            if (clientLCManager == null) throw new IllegalStateException("ClientLCManager is required");
            return new Bootstrap(this);
        }
    }
}
