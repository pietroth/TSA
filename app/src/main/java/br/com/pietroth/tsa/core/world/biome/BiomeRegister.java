package br.com.pietroth.tsa.core.world.biome;

public interface BiomeRegister {
    void register(BiomeType biomeType);
    BiomeType get(int id);
}