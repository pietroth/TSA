package br.com.pietroth.tsa.core.game.physics.movement;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

import br.com.pietroth.tsa.core.engine.communication.codec.Codec;

public class EntityMoveCodec implements Codec<MoveData> {

    @Override
    public int size() {
        return (int) HEADER_SIZE;
    }

    @Override
    public int size(MoveData data) {
        return size();
    }

    @Override
    public void encode(MemorySegment dest, MoveData data) {
        VH_SX.set(dest, 0L, data.sx);
        VH_SY.set(dest, 0L, data.sy);
    }

    @Override
    public MoveData decode(MemorySegment src) {
        float sx = (float) VH_SX.get(src, 0L);
        float sy = (float) VH_SY.get(src, 0L);

        return new MoveData(sx, sy);
    }

    private static final StructLayout HEADER_LAYOUT = MemoryLayout.structLayout(
        ValueLayout.JAVA_FLOAT.withName("sx"),
        ValueLayout.JAVA_FLOAT.withName("sy")
    );

    private static final VarHandle VH_SX = HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("sx"));
    private static final VarHandle VH_SY = HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("sy"));
    
    private static final long HEADER_SIZE = HEADER_LAYOUT.byteSize();   
}
