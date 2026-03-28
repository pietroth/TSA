package br.com.pietroth.tsa.core.world.generation;

public interface NoiseAlgorithm {
    float getNoise(float x, float y);
    long getSeed();
}
