package br.com.pietroth.tsa;

import br.com.pietroth.tsa.infrastructure.ecs.dominion.DominionRuntime;
import br.com.pietroth.tsa.core.engine.communication.codec.CodecRegistry;
import br.com.pietroth.tsa.core.game.application.player.PlayerMovementUseCase;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {

    public static void main(String[] args) {

        // ECS Runtime
        DominionRuntime runtime = new DominionRuntime();

        // Game Loop
        Bootstrap bootstrap = new Bootstrap.Builder()
            .ecsRuntime(runtime)
            .codecRegistry(new CodecRegistry())
            .build();
        bootstrap.boot();

        // Movement UseCase
        PlayerMovementUseCase playerMovement =
                new PlayerMovementUseCase(runtime.getContainer());

        // Input
        JFrame frame = new JFrame("TSA Debug Input");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {

                    case KeyEvent.VK_W: 
                        playerMovement.execute(1, 0, 1);
                        System.out.println("W");
                        break;

                    case KeyEvent.VK_S:
                        playerMovement.execute(1, 0, -1);
                        System.out.println("S");
                        break;

                    case KeyEvent.VK_A:
                        playerMovement.execute(1, 1, 0);
                        System.out.println("A");
                        break;

                    case KeyEvent.VK_D:
                        playerMovement.execute(1, -1, 0);
                        System.out.println("D");
                        break;

                }

            }

        });

        frame.setVisible(true);
        frame.requestFocus();

    }

}