package br.com.pietroth.tsa.core.communication.player.playermoved;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.communication.event.codec.Codec;

public class PlayerMovementCodec implements Codec<PlayerMovementData> {

    @Override
    public int size(PlayerMovementData data) {
        return size(); // sx + sy
    }

    @Override
    public int size() {
        return Float.BYTES * 2; // sx + sy
    }

    @Override
    public void encode(ByteBuffer buffer, PlayerMovementData data) {
        buffer.putFloat(data.sx);
        buffer.putFloat(data.sy);
    }

    @Override
    public PlayerMovementData decode(ByteBuffer buffer) {
        float sx = buffer.getFloat();
        float sy = buffer.getFloat();

        return new PlayerMovementData(sx, sy);
    }
    
}
