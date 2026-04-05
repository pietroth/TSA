package br.com.pietroth.tsa.core.world.block;

public interface BlockRegister {
    void register(BlockType blockType);
    BlockType get(int id);
}
