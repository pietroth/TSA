package br.com.pietroth.tsa.infrastructure.worldgeneration.simplexnoise;

import br.com.pietroth.tsa.core.world.generation.NoiseAlgorithm;
import de.articdive.jnoise.generators.noisegen.opensimplex.FastSimplexNoiseGenerator;
import de.articdive.jnoise.pipeline.JNoise;
import de.articdive.jnoise.modules.octavation.fractal_functions.FractalFunction;

public class SimplexNoiseAlgorithm implements NoiseAlgorithm {
    private final JNoise jnoise;
    private final long seed;

    public SimplexNoiseAlgorithm(long seed) {
        this.seed = seed;
        this.jnoise = JNoise.newBuilder()
            .fastSimplex(FastSimplexNoiseGenerator.newBuilder().setSeed(this.seed).build())
            .octavate(
                2,               
                0.5,              
                1.3,                 
                FractalFunction.TURBULENCE, 
                true)
            .abs()
            .clamp(0, 1)
            .build();
    }

    @Override
    public float getNoise(float x, float y) {
         return (float) jnoise.evaluateNoise(x, y);
    }

    @Override
    public long getSeed() {
        return seed;
    }
}
