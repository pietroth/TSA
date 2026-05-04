package br.com.pietroth.tsa.core.game.world.biome;

public class Biomes {
    private final BiomeRegister biomeRegister;
    private final BiomeType[] biomeTypes;

    public Biomes(BiomeRegister biomeRegister) {
        this.biomeRegister = biomeRegister;
        this.biomeTypes = new BiomeType[16];

        addBiome(new BiomeType(1, 10)); // plains; block: grass;
        addBiome(new BiomeType(10, 2)); // ocean; block: water;
        addBiome(new BiomeType(11, 3)); // lake; block: lake_water;
        addBiome(new BiomeType(2, 12)); // desert; block: sand;

        registerBiomes();
    }

    private void addBiome(BiomeType biomeType) {
        biomeTypes[biomeType.getId()] = biomeType;
    }

    private void registerBiomes() {
        for (BiomeType biomeType : biomeTypes) {
            biomeRegister.register(biomeType);
        }
    }
}
