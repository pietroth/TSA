package br.com.pietroth.tsa.core.game.world.block;

public class Block {
    private BlockType type;
    private byte state; // 0-15 for different block states (e.g., orientation, growth stage)

    public Block(BlockType type, byte state) {
        this.type = type;
        this.state = state;
    }

    public BlockType getType() {
        return type;
    }

    public void setType(BlockType type) {
        this.type = type;
    }

    public byte getState() {
        return state;
    }

    public void setDefaultState() {
        this.state = 0; // Default state for the block type
    }

    public void setState(byte state) {
        this.state = state;
    }
}
