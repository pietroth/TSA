package br.com.pietroth.tsa.core.game.world.biome;

import java.util.List;
import java.util.ArrayList;

public class Biomes {
    private final BiomeRegister biomeRegister;
    private final List<BiomeType> biomeTypes;

    public Biomes(BiomeRegister biomeRegister) {
        this.biomeRegister = biomeRegister;
        this.biomeTypes = new ArrayList<>();

        addBiome(new BiomeType(1, 10)); // plains; block: grass;
        addBiome(new BiomeType(10, 2)); // ocean; block: water;
        addBiome(new BiomeType(11, 3)); // lake; block: lake_water;
        addBiome(new BiomeType(2, 12)); // desert; block: sand;

        registerBiomes();
    }

    private void addBiome(BiomeType biomeType) {
        biomeTypes.add(biomeType);
    }

    private void registerBiomes() {
        for (BiomeType biomeType : biomeTypes) {
            biomeRegister.register(biomeType);
        }
    }
}
