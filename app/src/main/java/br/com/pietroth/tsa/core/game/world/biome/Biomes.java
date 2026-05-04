package br.com.pietroth.tsa.core.game.world.biome;

public final class Biomes {

    private Biomes() {}

    public static void registerAll(BiomeRegister biomeRegister) {
        if (biomeRegister == null) {
            throw new IllegalStateException("BiomeRegister is required");
        }

        biomeRegister.register(new BiomeType(1, 10)); // plains; block: grass;
        biomeRegister.register(new BiomeType(10, 2)); // ocean; block: water;
        biomeRegister.register(new BiomeType(11, 3)); // lake; block: water;
        biomeRegister.register(new BiomeType(2, 12)); // desert; block: sand;
    }
}
