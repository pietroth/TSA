package br.com.pietroth.tsa;

import br.com.pietroth.tsa.infrastructure.ecs.dominion.DominionRuntime;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.engine.network.NetworkAggregator;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManager;
import br.com.pietroth.tsa.core.engine.network.protocol.IntentionGateway;
import br.com.pietroth.tsa.core.engine.runtime.ComponentResolver;
import br.com.pietroth.tsa.core.game.player.Player2EntityResolver;
import br.com.pietroth.tsa.core.game.player.PlayerLCManager;
import br.com.pietroth.tsa.core.game.world.block.MemoryBlockRegister;

public class App {

    public static void main(String[] args) {

        // ECS Runtime
        DominionRuntime runtime = new DominionRuntime();
        Player2EntityResolver player2EntityResolver = new Player2EntityResolver();
        ComponentResolver componentResolver =
            new ComponentResolver();
        ClientLCManager clientLCManager = 
            new ClientLCManager(10, new IntentionGateway(componentResolver, new IntentionDecoder()));
        PlayerLCManager playerLCManager = new PlayerLCManager(player2EntityResolver, runtime.getContainer());

        // Game Loop
        Bootstrap bootstrap = new Bootstrap.Builder()
            .ecsRuntime(runtime)
            .blockRegister(new MemoryBlockRegister(32))
            .componentResolver(componentResolver)
            .clientLCManager(clientLCManager)
            .player2EntityResolver(player2EntityResolver)
            .playerLCManager(playerLCManager)
            .networkAggregator(new NetworkAggregator(20, 20))
            .build();
        bootstrap.boot();
        
        // Movement UseCase
        DebugWorldGeneration debugWorldGeneration = new DebugWorldGeneration();
        debugWorldGeneration.start();
    }
}
