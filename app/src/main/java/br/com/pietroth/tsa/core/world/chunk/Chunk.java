package br.com.pietroth.tsa.core.world.chunk;

import br.com.pietroth.tsa.core.world.WorldConfiguration;

public class Chunk {

    private final int x, y;
    private final short[] blocks;
    private boolean isCave;

    public Chunk(int x, int y) {
        this.x = x;
        this.y = y;

        int size = WorldConfiguration.BLOCKS_PER_CHUNK;
        this.blocks = new short[size * size];
    }

    private int index(int bx, int by) {
        int size = WorldConfiguration.BLOCKS_PER_CHUNK;
        return bx + by * size;
    }

    public short getBlock(int bx, int by) {
        return blocks[index(bx, by)];
    }

    public void setBlock(int bx, int by, short block) {
        blocks[index(bx, by)] = block;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCave() {
        return isCave;
    }

    public void setCave(boolean cave) {
        isCave = cave;
    }

    public int getGlobalBlockX(int localX) {
        return x * WorldConfiguration.BLOCKS_PER_CHUNK + localX;
    }

    public int getGlobalBlockY(int localY) {
        return y * WorldConfiguration.BLOCKS_PER_CHUNK + localY;
    }
}