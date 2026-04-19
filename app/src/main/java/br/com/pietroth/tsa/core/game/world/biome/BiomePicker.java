package br.com.pietroth.tsa.core.game.world.biome;

import br.com.pietroth.tsa.core.engine.world.WorldConstants;

public class BiomePicker {
    private final BiomeRegister biomeRegister;

    public BiomePicker(BiomeRegister biomeRegister) {
        this.biomeRegister = biomeRegister;
    }

    public BiomeType pickBiome(float temperature, float elevation, float humidity, float lake) {
        if (elevation < WorldConstants.SEA_LEVEL) {
            return biomeRegister.get(10); // ocean
        }

        if (lake < 0.08f && elevation > WorldConstants.SEA_LEVEL) {
            return biomeRegister.get(11); // lake
        }

        if (temperature > 0.55 && humidity < 0.40) {
            return biomeRegister.get(2); // desert
        }

        return biomeRegister.get(1); // plains
    }
}