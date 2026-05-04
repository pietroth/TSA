package br.com.pietroth.tsa.core.game.world.chunk;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;

public class MemoryChunkLoader implements ChunkLoader {
    private final Long2ObjectMap<Chunk> loadedChunks;

    public MemoryChunkLoader( ) {
       loadedChunks = new Long2ObjectOpenHashMap<>();
    }

    @Override
    public void load(Chunk chunk) {
        loadedChunks.put(pack(chunk.getX(), chunk.getY()), chunk);
    }

    @Override
    public boolean isLoaded(int x, int y) {
        return loadedChunks.containsKey(pack(x, y));
    }

    @Override
    public void unload(int x, int y) {
        loadedChunks.remove(pack(x, y));
    }

    @Override
    public Chunk getChunk(int x, int y) {
        return loadedChunks.get(pack(x, y));
    }

    private long pack(int x, int y) {
        return ((long) x << 32) | (y & 0xFFFFFFFFL);
    }
}
