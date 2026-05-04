package br.com.pietroth.tsa.core.game.world.chunk;

public record ChunkPosition(int x, int y) {
    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
