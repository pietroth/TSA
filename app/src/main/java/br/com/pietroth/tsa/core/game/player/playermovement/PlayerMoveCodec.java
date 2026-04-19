package br.com.pietroth.tsa.core.engine.communication.player.playermovement;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.engine.communication.codec.Codec;

public class PlayerMoveCodec implements Codec<PlayerMoveData> {

    @Override
    public int size(PlayerMoveData data) {
        return size(); // sx + sy
    }

    @Override
    public int size() {
        return Float.BYTES * 2; // sx + sy
    }

    @Override
    public void encode(ByteBuffer buffer, PlayerMoveData data) {
        buffer.putFloat(data.sx);
        buffer.putFloat(data.sy);
    }

    @Override
    public PlayerMoveData decode(ByteBuffer buffer) {
        float sx = buffer.getFloat();
        float sy = buffer.getFloat();

        return new PlayerMoveData(sx, sy);
    }
    
}
