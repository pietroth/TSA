package br.com.pietroth.tsa.core.game.world.block;

public final class Blocks {

    private Blocks() {}

    public static void registerAll(BlockRegister blockRegister) {
        if (blockRegister == null) {
            throw new IllegalStateException("BlockRegister is required");
        }

        blockRegister.register(new BlockType(1, false, 0));   // air
        blockRegister.register(new BlockType(10, true, 1.1f)); // grass
        blockRegister.register(new BlockType(11, true, 0.9f)); // dirt
        blockRegister.register(new BlockType(20, true, 3.0f)); // stone
        blockRegister.register(new BlockType(2, false, 0));   // water
        blockRegister.register(new BlockType(12, true, 0.8f)); // sand
    }
}