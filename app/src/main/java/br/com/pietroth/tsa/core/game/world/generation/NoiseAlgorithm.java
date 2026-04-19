package br.com.pietroth.tsa.core.game.world.generation;

public interface NoiseAlgorithm {
    float getNoise(float x, float y);
    long getSeed();
}
