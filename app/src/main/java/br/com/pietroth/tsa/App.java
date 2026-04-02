package br.com.pietroth.tsa;

import br.com.pietroth.tsa.core.application.MovementUseCase;
import br.com.pietroth.tsa.core.event.codec.CodecRegistry;
import br.com.pietroth.tsa.core.GameLoop;
import br.com.pietroth.tsa.infrastructure.ecs.dominion.DominionRuntime;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {

    public static void main(String[] args) {

        // ECS Runtime
        DominionRuntime runtime = new DominionRuntime();
        CodecRegistry codecRegistry = new CodecRegistry();

        // Game Loop
        GameLoop loop = GameLoop.builder()
                .ecsRuntime(runtime)
                .registry(codecRegistry)
                .build();
                
        new Thread(loop).start();

        // Movement UseCase
        MovementUseCase movementUseCase =
                new MovementUseCase(runtime.getContainer());

        // Input
        JFrame frame = new JFrame("TSA Debug Input");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {

                    case KeyEvent.VK_W: 
                        movementUseCase.execute(0, 1);
                        System.out.println("W");
                        break;

                    case KeyEvent.VK_S:
                        movementUseCase.execute(0, -1);
                        System.out.println("S");
                        break;

                    case KeyEvent.VK_A:
                        movementUseCase.execute(1, 0);
                        System.out.println("A");
                        break;

                    case KeyEvent.VK_D:
                        movementUseCase.execute(-1, 0);
                        System.out.println("D");
                        break;

                }

            }

        });

        frame.setVisible(true);
        frame.requestFocus();

    }

}