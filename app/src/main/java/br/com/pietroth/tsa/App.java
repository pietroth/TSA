package br.com.pietroth.tsa;

import br.com.pietroth.tsa.infrastructure.ecs.dominion.DominionRuntime;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.engine.network.NetworkAggregator;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManager;
import br.com.pietroth.tsa.core.engine.network.protocol.IntentionGateway;
import br.com.pietroth.tsa.core.engine.runtime.ComponentResolver;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveData;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveUseCase;
import br.com.pietroth.tsa.core.game.world.block.MemoryBlockRegister;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {

    public static void main(String[] args) {

        // ECS Runtime
        DominionRuntime runtime = new DominionRuntime();
        ComponentResolver componentResolver =
            new ComponentResolver();
        ClientLCManager clientLCManager = 
            new ClientLCManager(10, new IntentionGateway(componentResolver, new IntentionDecoder()));

        // Game Loop
        Bootstrap bootstrap = new Bootstrap.Builder()
            .ecsRuntime(runtime)
            .blockRegister(new MemoryBlockRegister(32))
            .componentResolver(componentResolver)
            .clientLCManager(clientLCManager)
            .networkAggregator(new NetworkAggregator(20, 20))
            .build();
        bootstrap.boot();

        // Movement UseCase
        PlayerMoveUseCase playerMovement =
                new PlayerMoveUseCase(runtime.getContainer());

        // Input
        JFrame frame = new JFrame("TSA Debug Input");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {
        
                    case KeyEvent.VK_W:
                        playerMovement.execute(1, new PlayerMoveData(0, 1));
                        System.out.println("W");
                        break;

                    case KeyEvent.VK_S:
                        playerMovement.execute(1, new PlayerMoveData(0, -1));
                        System.out.println("S");
                        break;

                    case KeyEvent.VK_A:
                        playerMovement.execute(1, new PlayerMoveData(-1, 0));
                        System.out.println("A");
                        break;

                    case KeyEvent.VK_D:
                        playerMovement.execute(1, new PlayerMoveData(1, 0));
                        System.out.println("D");
                        break;

                }

            }

        });

        frame.setVisible(true);
        frame.requestFocus();

    }

}
