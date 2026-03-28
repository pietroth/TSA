package br.com.pietroth.tsa.infrastructure.world_generation.simplex_noise;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DebugSimplexNoiseAlgorithm {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static float scale = 100.0f; // initial zoom level
    private static JLabel imageLabel;


    public static void main(String[] args) {
        // create the GUI
        JFrame frame = new JFrame("Simplex Noise Interactive Preview");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageLabel = new JLabel();
        frame.add(imageLabel);
        frame.pack();
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // controls zoom with + and - keys
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '+') scale *= 1.2; // increases zoom
                else if (e.getKeyChar() == '-') scale /= 1.2; // decreases zoom
            }
        });

        // timer to update noise image every second with a new seed
        Timer timer = new Timer(1000, e -> {
            long seed = new Random().nextLong();
            SimplexNoiseAlgorithm noiseAlg = new SimplexNoiseAlgorithm(seed);
            BufferedImage img = generateNoiseImage(noiseAlg, scale);
            imageLabel.setIcon(new ImageIcon(img));
        });
        timer.start();
    }

    private static BufferedImage generateNoiseImage(SimplexNoiseAlgorithm noiseAlg, float scale) {
        BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                float nx = x / scale;
                float ny = y / scale;
                float val = noiseAlg.getNoise(nx, ny); // -1..1
                int color = (int)(val * 255);
                color = Math.max(0, Math.min(255, color));
                int rgb = new Color(color, color, color).getRGB();
                img.setRGB(x, y, rgb);
            }
        }

        return img;
    }
}