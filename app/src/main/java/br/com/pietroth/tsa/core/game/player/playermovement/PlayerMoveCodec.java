package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.communication.codec.Codec;

public class PlayerMoveCodec implements Codec<PlayerMoveData> {

    @Override
    public int size(PlayerMoveData data) {
        return size(); // playerId + sx + sy
    }

    @Override
    public int size() {
        return Integer.BYTES + (Float.BYTES * 2); // playerId + sx + sy
    }

    @Override
        public void encode(byte[] raw, int offset, PlayerMoveData data) {
        // Encode PlayerID (int)
        int pId = data.playerId;
        raw[offset++] = (byte) (pId >> 24);
        raw[offset++] = (byte) (pId >> 16);
        raw[offset++] = (byte) (pId >> 8);
        raw[offset++] = (byte) pId;

        // Encode SX (bits -> int)
        int sxBits = Float.floatToIntBits(data.sx);
        raw[offset++] = (byte) (sxBits >> 24);
        raw[offset++] = (byte) (sxBits >> 16);
        raw[offset++] = (byte) (sxBits >> 8);
        raw[offset++] = (byte) sxBits;

        // Encode SY (bits -> int)
        int syBits = Float.floatToIntBits(data.sy);
        raw[offset++] = (byte) (syBits >> 24);
        raw[offset++] = (byte) (syBits >> 16);
        raw[offset++] = (byte) (syBits >> 8);
        raw[offset++] = (byte) syBits;
    }

    @Override
    public PlayerMoveData decode(byte[] raw, int offset) {
        // Decode PlayerID
        int playerId = 
            (raw[offset++] & 0xFF) << 24 |
            (raw[offset++] & 0xFF) << 16 |
            (raw[offset++] & 0xFF) << 8 |
            (raw[offset++] & 0xFF);

        // Decode SX
        int sxBits = 
            (raw[offset++] & 0xFF) << 24 |
            (raw[offset++] & 0xFF) << 16 |
            (raw[offset++] & 0xFF) << 8 |
            (raw[offset++] & 0xFF);
        float sx = Float.intBitsToFloat(sxBits);

        // Decode SY
        int syBits = 
            (raw[offset++] & 0xFF) << 24 |
            (raw[offset++] & 0xFF) << 16 |
            (raw[offset++] & 0xFF) << 8 |
            (raw[offset++] & 0xFF);
        float sy = Float.intBitsToFloat(syBits);

        return new PlayerMoveData(playerId, sx, sy);
    }
}
