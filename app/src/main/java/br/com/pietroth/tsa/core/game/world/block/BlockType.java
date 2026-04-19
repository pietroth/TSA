package br.com.pietroth.tsa.core.game.world.block;

public class BlockType {
    private int id;
    private boolean isSolid;
    private float hardness;

    public BlockType(int id, boolean isSolid, float hardness) {
        this.id = id;
        this.isSolid = isSolid;
        this.hardness = hardness;
    }

    public int getId() {
        return id;
    }

    public boolean isSolid() {
        return isSolid;
    }

    public float getHardness() {
        return hardness;
    }
}
