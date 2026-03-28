package br.com.pietroth.tsa.core.world.biome;

import java.util.HashMap;
import java.util.Map;

public class MemoryBiomeRegister implements BiomeRegister {
    private final Map<Integer, BiomeType> biomeTypes = new HashMap<>();

    @Override
    public void register(BiomeType biomeType) {
        biomeTypes.put(biomeType.getId(), biomeType);
    }

    @Override
    public BiomeType get(int id) {
        return biomeTypes.get(id);
    }
}
