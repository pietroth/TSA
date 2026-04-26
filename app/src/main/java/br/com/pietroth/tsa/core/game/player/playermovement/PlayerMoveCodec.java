package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

public class PlayerMoveCodec implements Codec<PlayerMoveData> {

    private static final StructLayout LAYOUT = MemoryLayout.structLayout(
        ValueLayout.JAVA_INT.withName("playerId"),
        ValueLayout.JAVA_FLOAT.withName("sx"),
        ValueLayout.JAVA_FLOAT.withName("sy")
    );

    private static final VarHandle VH_PLAYER_ID = LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("playerId"));
    private static final VarHandle VH_SX = LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("sx"));
    private static final VarHandle VH_SY = LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("sy"));

    @Override
    public int size(PlayerMoveData data) {
        return size();
    }

    @Override
    public int size() {
        return (int) LAYOUT.byteSize(); // 12 bytes
    }

    @Override
    public void encode(MemorySegment dest, PlayerMoveData data) {
        VH_PLAYER_ID.set(dest, 0L, data.playerId);
        VH_SX.set(dest, 0L, data.sx);
        VH_SY.set(dest, 0L, data.sy);
    }

    @Override
    public PlayerMoveData decode(MemorySegment src) {
        int playerId = (int) VH_PLAYER_ID.get(src, 0L);
        float sx = (float) VH_SX.get(src, 0L);
        float sy = (float) VH_SY.get(src, 0L);

        return new PlayerMoveData(playerId, sx, sy);
    }
}
