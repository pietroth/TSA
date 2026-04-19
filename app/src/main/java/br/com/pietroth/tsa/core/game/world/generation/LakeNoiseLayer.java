package br.com.pietroth.tsa.core.game.world.generation;

public class LakeNoiseLayer implements NoiseLayer {
    private NoiseAlgorithm alg;
    private final float frequency;
    private final float amplitude;

    public LakeNoiseLayer(NoiseAlgorithm noiseAlgorithm) {
        this.alg = noiseAlgorithm;
        this.frequency = 0.0015f;
        this.amplitude = 0.4f;
    }

    @Override 
    public float getNoise(float x, float y) {
        return (float)(amplitude * alg.getNoise(x * frequency, y * frequency));
    }
}
