package br.com.pietroth.tsa.core.event.player.playermoved;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.event.codec.EventCodec;

public class PlayerMovedCodec implements EventCodec<PlayerMovedData> {

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
