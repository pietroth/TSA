package br.com.pietroth.tsa.core.game.world.block;

public class MemoryBlockRegister implements BlockRegister {

    private final BlockType[] blockTypes;

    public MemoryBlockRegister(int maxId) {
        this.blockTypes = new BlockType[maxId + 1];
    }

    @Override
    public void register(BlockType blockType) {
        int id = blockType.getId();
        blockTypes[id] = blockType;
    }

    @Override
    public BlockType get(int id) {
        return blockTypes[id];
    }
}