package br.com.pietroth.tsa.core.engine.communication.response;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

public class IRCodec {
    public MemorySegment encode(Arena arena, IR ir) {
        MemorySegment segment = arena.allocate(HEADER_SIZE);
        
        VH_TOTAL_SIZE.set(segment, 0L, HEADER_SIZE);
        VH_CORRELATION.set(segment, 0L, ir.getCorrelationId());
        VH_STATUS.set(segment, 0L, ir.getStatus());

        return segment;
    }

    public IR decode(MemorySegment segment) {
        int correlationId = (int) VH_CORRELATION.get(segment, 0L);
        byte status = (byte) VH_STATUS.get(segment, 0L);

        return new IR(status, correlationId);
    }

    private static final StructLayout HEADER_LAYOUT = MemoryLayout.structLayout(
        ValueLayout.JAVA_INT.withName("totalSize"),
        ValueLayout.JAVA_INT.withName("correlationId"),
        ValueLayout.JAVA_BYTE.withName("status")
    );

    private static final VarHandle VH_TOTAL_SIZE = 
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("totalSize"));

    private static final VarHandle VH_CORRELATION = 
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("correlationId"));
    private static final VarHandle VH_STATUS = 
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("status"));

    private static final long HEADER_SIZE = HEADER_LAYOUT.byteSize();
}
