package br.com.pietroth.tsa.core.game.world.generation;

public class ElevationNoiseLayer implements NoiseLayer {
    private final NoiseAlgorithm alg;
    private final float frequency;
    private final float amplitude;

    public ElevationNoiseLayer(NoiseAlgorithm noiseAlgorithm) {
        this.alg = noiseAlgorithm;
        this.frequency = 0.0006f;
        this.amplitude = 1f;
    }

    @Override
    public float getNoise(float x, float y) {
        return (float)(amplitude * alg.getNoise(x * frequency, y * frequency));
    }
}