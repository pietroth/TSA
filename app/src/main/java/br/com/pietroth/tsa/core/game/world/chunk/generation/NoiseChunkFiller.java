package br.com.pietroth.tsa.core.game.world.chunk.generation;

import br.com.pietroth.tsa.core.game.world.WorldConstants;
import br.com.pietroth.tsa.core.game.world.biome.BiomePicker;
import br.com.pietroth.tsa.core.game.world.chunk.Chunk;
import br.com.pietroth.tsa.core.game.world.generation.NoiseLayer;
import br.com.pietroth.tsa.core.game.world.biome.BiomeType;

public class NoiseChunkFiller implements ChunkFiller {
    private final BiomePicker biomePicker;
    private final NoiseLayer firstNoiseLayer;
    private final NoiseLayer secondNoiseLayer;
    private final NoiseLayer thirdNoiseLayer;
    private final NoiseLayer fourthNoiseLayer;

    public NoiseChunkFiller(
            BiomePicker biomePicker,
            NoiseLayer firstNoiseLayer,
            NoiseLayer secondNoiseLayer,
            NoiseLayer thirdNoiseLayer,
            NoiseLayer fourthNoiseLayer
        ){

        this.biomePicker = biomePicker;
        this.firstNoiseLayer = firstNoiseLayer;
        this.secondNoiseLayer = secondNoiseLayer;
        this.thirdNoiseLayer = thirdNoiseLayer;
        this.fourthNoiseLayer = fourthNoiseLayer;
    }

    @Override
    public void fill(Chunk chunk) {

        int size = WorldConstants.BLOCKS_PER_CHUNK;

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {

                int globalX = chunk.getGlobalBlockX(x);
                int globalY = chunk.getGlobalBlockY(y);

                float first = fractalNoise(firstNoiseLayer, globalX, globalY, 4, 0.5f, 2.0f);
                float second = fractalNoise(secondNoiseLayer, globalX, globalY, 5, 0.5f, 2.0f);
                float third = fractalNoise(thirdNoiseLayer, globalX, globalY, 4, 0.5f, 2.0f);
                float fourth = fractalNoise(fourthNoiseLayer, globalX, globalY, 4, 0.5f, 2.0f);

                BiomeType biome = biomePicker.pickBiome(first, second, third, fourth);

                int blockId = biome.getSurfaceBlockId();
                byte state = 0;

                short encodedBlock = encodeBlock(blockId, state);

                chunk.setBlock(x, y, encodedBlock);
            }
        }
    }

    private short encodeBlock(int id, byte state) {
        return (short) ((id << 4) | (state & 0xF));
    }

    private float fractalNoise(
        NoiseLayer noise, float x, float y, int octaves, float persistence, float lacunarity) 
    {
        float amplitude = 1.0f;
        float frequency = 1.0f;
        float value = 0.0f;
        float max = 0.0f;

        for (int i = 0; i < octaves; i++) {
            value += noise.getNoise(x * frequency, y * frequency) * amplitude;

            max += amplitude;

            amplitude *= persistence;
            frequency *= lacunarity;
        }

        return value / max;
    }
}