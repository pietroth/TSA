package br.com.pietroth.tsa.core.game.world.biome;

public class Biome {
    private final BiomeType type;
    
    public Biome(BiomeType type) {
        this.type = type;
    }

    public BiomeType getType() {
        return type;
    }
}
