package br.com.pietroth.tsa.core.game.world;
 
import br.com.pietroth.tsa.core.game.world.chunk.ChunkManager;
import br.com.pietroth.tsa.core.game.world.chunk.Chunk;

public class WorldHandler {
    private final World world;
    private final ChunkManager chunkManager;
    private final WorldEngineer worldEngineer;

    public WorldHandler(
        World world, 
        ChunkManager chunkManager,
        WorldEngineer worldEngineer
    ){
        this.world = world;
        this.chunkManager = chunkManager;
        this.worldEngineer = worldEngineer;
    }

    public World getWorld() {
        return this.world;
    }

    public ChunkManager getChunkManager() {
        return this.chunkManager;
    }

    public Chunk getChunk(int cx, int cy) {
        if (this.chunkManager.isChunkLoaded(cx, cy)) {
            return this.chunkManager.getChunk(cx, cy);
        }
        this.chunkManager.generateChunk(cx, cy);
        return this.chunkManager.getChunk(cx, cy);
    }

    public void unloadChunk(int cx, int cy) {
        if (this.chunkManager.isChunkLoaded(cx, cy)) {
            this.chunkManager.unloadChunk(new Chunk(cx, cy));
        }
    }

    public boolean isChunkLoaded(int cx, int cy) {
        return this.chunkManager.isChunkLoaded(cx, cy);
    }

    public void createWorld() {
        this.worldEngineer.createWorld(this.world.getWorldData());
    }
}
