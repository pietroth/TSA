package br.com.pietroth.tsa.core.game.world.chunk;

import java.util.Map;
import java.util.HashMap;

public class MemoryChunkLoader implements ChunkLoader {
    private final Map<ChunkPosition, Chunk> loadedChunks;

    public MemoryChunkLoader( ) {
       loadedChunks = new HashMap<>();
    }

    @Override
    public void load(Chunk chunk) {
        ChunkPosition pos = new ChunkPosition(chunk.getX(), chunk.getY());
        loadedChunks.put(pos, chunk);
    }

    @Override
    public boolean isLoaded(int x, int y) {
        ChunkPosition pos = new ChunkPosition(x, y);
        return loadedChunks.containsKey(pos);
    }

    @Override
    public void unload(int x, int y) {
        loadedChunks.remove(new ChunkPosition(x, y));
    }

    @Override
    public Chunk getChunk(int x, int y) {
        return loadedChunks.get(new ChunkPosition(x, y));
    }
}
