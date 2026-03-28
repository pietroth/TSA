package br.com.pietroth.tsa.core.world.block;

import java.util.ArrayList;
import java.util.List;

public class Blocks {
    private BlockRegister blockRegister;
    private List<BlockType> blocks;

    public Blocks(BlockRegister blockRegister) {
        this.blockRegister = blockRegister;
        this.blocks = new ArrayList<>();

        addBlock(new BlockType(1, false, 0)); // air
        addBlock(new BlockType(10, true, 1.1f)); // grass
        addBlock(new BlockType(11, true, 0.9f)); // dirt
        addBlock(new BlockType(20, true, 3.0f)); // stone
        addBlock(new BlockType(2, false, 0)); // water
        addBlock(new BlockType(12, true, 0.8f)); // sand

        registerBlocks();
    }

    private void addBlock(BlockType block) {
        this.blocks.add(block);
    }

    private void registerBlocks() {
        for (BlockType blockType : blocks) {
                blockRegister.register(blockType);
            }
    }
}
