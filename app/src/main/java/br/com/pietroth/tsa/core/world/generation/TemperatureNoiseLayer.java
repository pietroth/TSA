package br.com.pietroth.tsa.core.world.generation;

public class TemperatureNoiseLayer implements NoiseLayer {
    private final NoiseAlgorithm alg;
    private final float frequency;
    private final float amplitude;

    public TemperatureNoiseLayer(NoiseAlgorithm noiseAlgorithm) {
        this.alg = noiseAlgorithm;
        this.frequency = 0.0012f;
        this.amplitude = 1f;
    }

    @Override
    public float getNoise(float x, float y) {
        return (float)(amplitude * alg.getNoise(x * frequency, y * frequency));
    }
}