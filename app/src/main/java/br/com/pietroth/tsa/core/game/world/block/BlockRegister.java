package br.com.pietroth.tsa.core.game.world.block;

public interface BlockRegister {
    void register(BlockType blockType);
    BlockType get(int id);
}
