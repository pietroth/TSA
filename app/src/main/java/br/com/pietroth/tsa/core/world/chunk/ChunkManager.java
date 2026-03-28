package br.com.pietroth.tsa.core.world.chunk;

import br.com.pietroth.tsa.core.world.chunk.generation.ChunkFiller;

public class ChunkManager {
    private final ChunkLoader chunkLoader;
    private final ChunkFiller chunkFiller;

    public ChunkManager(ChunkLoader chunkLoader, ChunkFiller chunkFiller) {
        this.chunkLoader = chunkLoader;
        this.chunkFiller = chunkFiller;
    }

    public void loadChunk(Chunk chunk) {
        if (!chunkLoader.isLoaded(chunk.getX(), chunk.getY())) {
            chunkLoader.load(chunk);
        }
    }

    public void unloadChunk(Chunk chunk) {
        if (chunkLoader.isLoaded(chunk.getX(), chunk.getY())) {
            chunkLoader.unload(chunk.getX(), chunk.getY());
        }
    }

    public void generateChunk(int x, int y) {
        if (!chunkLoader.isLoaded(x, y)) {
            Chunk chunk = new Chunk(x, y);
            chunkFiller.fill(chunk);
            chunkLoader.load(chunk);
        }
    }

    public boolean isChunkLoaded(int x, int y) {
        return chunkLoader.isLoaded(x, y);
    }

    public Chunk getChunk(int x, int y) {
        if (chunkLoader.isLoaded(x, y)) {
            return chunkLoader.getChunk(x, y);
        }
        return null;
    }
}
