package br.com.pietroth.tsa.core.game.world.chunk;

public interface ChunkLoader {
    void load(Chunk chunk);
    boolean isLoaded(int x, int y);
    void unload(int x, int y);
    Chunk getChunk(int x, int y);
}
