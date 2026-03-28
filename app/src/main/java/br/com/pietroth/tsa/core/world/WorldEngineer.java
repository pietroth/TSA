package br.com.pietroth.tsa.core.world;

import br.com.pietroth.tsa.core.world.chunk.ChunkManager;

public class WorldEngineer {
    private final ChunkManager chunkManager;

    public WorldEngineer(ChunkManager chunkManager) {
        this.chunkManager = chunkManager;
    }

    public World createWorld(WorldData worldData) {
        World world = new World(worldData, chunkManager);
        short size = WorldConfiguration.INITIAL_WORLD_SIZE;

        for (int x = -size / 2; x < size / 2; x++) {
            for (int y = -size / 2; y < size / 2; y++) {
                chunkManager.generateChunk(x, y);
            }
        }

        return world;
    }
}
