package br.com.pietroth.tsa.core.event.player.playermoved;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.event.codec.Codec;

public class PlayerMovedCodec implements Codec<PlayerMovedData> {

    @Override
    public int size(PlayerMovedData data) {
        return size(); // sx + sy
    }

    @Override
    public int size() {
        return Float.BYTES * 2; // sx + sy
    }

    @Override
    public void encode(ByteBuffer buffer, PlayerMovedData data) {
        buffer.putFloat(data.sx);
        buffer.putFloat(data.sy);
    }

    @Override
    public PlayerMovedData decode(ByteBuffer buffer) {
        float sx = buffer.getFloat();
        float sy = buffer.getFloat();

        return new PlayerMovedData(sx, sy);
    }
    
}
