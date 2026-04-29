package br.com.pietroth.tsa.core.engine.communication;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

import br.com.pietroth.tsa.core.engine.communication.codec.Codec;

public class MIDFEncoder {

    public <T extends MIDFData> MemorySegment encode(Arena arena, MIDF<T> MIDF, Codec<T> codec) {
        int payloadSize = codec.size();
        int totalSize = (int) HEADER_SIZE + payloadSize;

        MemorySegment segment = arena.allocate(totalSize);

        VH_TOTAL_SIZE.set(segment, 0L, totalSize);

        short midfId = (short) ((MIDF.getFamily() << 8) | (MIDF.getType()) & 0xFF);
        VH_MIDF_ID.set(segment, 0L, midfId);

        codec.encode(segment.asSlice(HEADER_SIZE), MIDF.getData());

        return segment;
    }

    private static final StructLayout HEADER_LAYOUT = MemoryLayout.structLayout(
        ValueLayout.JAVA_INT.withName("totalSize"),
        ValueLayout.JAVA_SHORT.withName("midfId"),
        MemoryLayout.paddingLayout(2)
    );

    private static final VarHandle VH_TOTAL_SIZE = 
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("totalSize"));

    private static final VarHandle VH_MIDF_ID = 
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("midfId"));

    private static final long HEADER_SIZE = HEADER_LAYOUT.byteSize();
}
