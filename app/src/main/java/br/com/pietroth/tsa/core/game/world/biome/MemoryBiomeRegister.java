package br.com.pietroth.tsa.core.game.world.biome;

public class MemoryBiomeRegister implements BiomeRegister {
    private final BiomeType[] biomeTypes;

    public MemoryBiomeRegister(int maxBiomes) {
        biomeTypes = new BiomeType[maxBiomes];
    }

    @Override
    public void register(BiomeType biomeType) {
        biomeTypes[biomeType.getId()] = biomeType;
    }

    @Override
    public BiomeType get(int id) {
        return biomeTypes[id];
    }
}
