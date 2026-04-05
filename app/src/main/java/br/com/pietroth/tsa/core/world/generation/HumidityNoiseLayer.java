package br.com.pietroth.tsa.core.world.generation;

public class HumidityNoiseLayer implements NoiseLayer {
    private final NoiseAlgorithm alg;
    private final float frequency;
    private final float amplitude;

    public HumidityNoiseLayer(NoiseAlgorithm noiseAlgorithm) {
        this.alg = noiseAlgorithm;
        this.frequency = 0.0008f;
        this.amplitude = 1f;
    }

    public float getNoise(float x, float y) {
        return (float)(amplitude * alg.getNoise(x * frequency, y * frequency));
    }
}
