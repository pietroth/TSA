package br.com.pietroth.tsa.core.game.world.block;

import java.util.HashMap;
import java.util.Map;

public class MemoryBlockRegister implements BlockRegister {
    private Map<Integer, BlockType> blockTypes = new HashMap<>();

    @Override
    public void register(BlockType blockType) {
        blockTypes.put(blockType.getId(), blockType);
    }

    @Override
    public BlockType get(int id) {
        return blockTypes.get(id);
    }
}
