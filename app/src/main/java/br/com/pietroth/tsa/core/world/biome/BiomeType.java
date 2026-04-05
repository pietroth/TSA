package br.com.pietroth.tsa.core.world.biome;

public class BiomeType {
    private final int id;
    private final int surfaceBlockId;

    public BiomeType(int id, int surfaceBlockId) {
        this.id = id;
        this.surfaceBlockId = surfaceBlockId;
    }

    public int getId() {
        return this.id;
    }

    public int getSurfaceBlockId() {
        return this.surfaceBlockId;
    }
}
