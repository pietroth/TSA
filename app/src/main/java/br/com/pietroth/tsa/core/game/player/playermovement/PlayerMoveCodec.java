package br.com.pietroth.tsa.core.game.player.playermovement;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.engine.communication.codec.Codec;

public class PlayerMoveCodec implements Codec<PlayerMoveData> {

    @Override
    public int size(PlayerMoveData data) {
        return size(); // playerId + sx + sy
    }

    @Override
    public int size() {
        return Integer.BYTES + Float.BYTES * 2; // playerId + sx + sy
    }

    @Override
    public void encode(ByteBuffer buffer, PlayerMoveData data) {
        buffer.putInt(data.playerId);
        buffer.putFloat(data.sx);
        buffer.putFloat(data.sy);
    }

    @Override
    public PlayerMoveData decode(ByteBuffer buffer) {
        int playerId = buffer.getInt();
        float sx = buffer.getFloat();
        float sy = buffer.getFloat();

        return new PlayerMoveData(playerId, sx, sy);
    }
    
}
