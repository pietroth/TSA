package br.com.pietroth.tsa.core.game.world;

import br.com.pietroth.tsa.core.game.world.chunk.ChunkManager;

public class World {
    private final WorldData worldData;

    public World(WorldData worldData, ChunkManager chunkManager) {
        this.worldData = worldData;
    }

    public WorldData getWorldData() {
        return worldData;
    }
}
