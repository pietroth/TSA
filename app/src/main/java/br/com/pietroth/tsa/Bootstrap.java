package br.com.pietroth.tsa;

import br.com.pietroth.tsa.core.engine.communication.event.EventPublisher;
import br.com.pietroth.tsa.core.engine.communication.event.EventPublisherSingleton;
import br.com.pietroth.tsa.core.engine.communication.MIDFEncoder;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.engine.communication.response.IRCodec;
import br.com.pietroth.tsa.core.engine.communication.response.IRPublisher;
import br.com.pietroth.tsa.core.engine.communication.response.IRPublisherSingleton;
import br.com.pietroth.tsa.core.engine.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.engine.network.MessageDeliveryHandler;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManager;
import br.com.pietroth.tsa.core.engine.network.protocol.IntentionGateway;
import br.com.pietroth.tsa.core.engine.runtime.ComponentResolver;
import br.com.pietroth.tsa.core.game.GameDataPipelineRegister;
import br.com.pietroth.tsa.core.game.GameLoop;
import br.com.pietroth.tsa.core.game.world.block.BlockRegister;
import br.com.pietroth.tsa.core.game.world.block.Blocks;

public class Bootstrap {
    private final ECSRuntime ecsRuntime;
    private final BlockRegister blockRegister;
    private final ComponentResolver componentResolver;
    private final ClientLCManager clientLCManager;

    public Bootstrap(Builder builder) {
        this.ecsRuntime = builder.ecsRuntime;
        this.blockRegister = builder.blockRegister;
        this.componentResolver = builder.componentResolver;
        this.clientLCManager = builder.clientLCManager;
    }

    public void boot() {
        MessageDeliveryHandler deliveryHandler = new MessageDeliveryHandler(clientLCManager);

        clientLCManager.setIntentionGateway(new IntentionGateway(componentResolver, new IntentionDecoder()));

        IRPublisherSingleton.init(new IRPublisher(new IRCodec(), deliveryHandler));
        EventPublisherSingleton.init(new EventPublisher(
            componentResolver,
            new MIDFEncoder(),
            deliveryHandler
        ));
        GameDataPipelineRegister.registerAll(componentResolver, ecsRuntime);

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
        private ComponentResolver componentResolver;
        private ClientLCManager clientLCManager;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public Builder blockRegister(BlockRegister blockRegister) {
            this.blockRegister = blockRegister;
            return this;
        }

        public Builder componentResolver(ComponentResolver componentResolver) {
            this.componentResolver = componentResolver;
            return this;
        }

        public Builder clientLCManager(ClientLCManager clientLCManager) {
            this.clientLCManager = clientLCManager;
            return this;
        }

        public Bootstrap build() {
            if (ecsRuntime == null) throw new IllegalStateException("ECSRuntime is required");
            if (blockRegister == null) throw new IllegalStateException("BlockRegister is required");
            if (componentResolver == null) throw new IllegalStateException("ComponentResolver is required");
            if (clientLCManager == null) throw new IllegalStateException("ClientLCManager is required");
            return new Bootstrap(this);
        }
    }
}
