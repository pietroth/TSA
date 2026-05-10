package br.com.pietroth.tsa.core.engine.communication.response;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

public class IRCodec {
    public MemorySegment encode(Arena arena, IR ir) {
        MemorySegment data = ir.getData();
        int payloadSize = data == null ? 0 : (int) data.byteSize();
        int totalSize = (int) HEADER_SIZE + payloadSize;

        MemorySegment segment = arena.allocate(totalSize);

        VH_TOTAL_SIZE.set(segment, 0L, totalSize);
        VH_CORRELATION.set(segment, 0L, ir.getCorrelationId());
        VH_STATUS.set(segment, 0L, ir.getStatus());
        VH_ERROR_CODE.set(segment, 0L, ir.getErrorCode());

        if (data != null && payloadSize > 0) {
            segment.asSlice(HEADER_SIZE, payloadSize).copyFrom(data);
        }

        return segment;
    }

    public IR decode(MemorySegment segment) {
        int correlationId = (int) VH_CORRELATION.get(segment, 0L);
        byte status = (byte) VH_STATUS.get(segment, 0L);
        byte errorCode = (byte) VH_ERROR_CODE.get(segment, 0L);

        IR.Builder builder = new IR.Builder();
        if (status == IR.SUCCESS) {
            return builder.success(correlationId, status).build();
        }

        if (status == IR.ERROR) {
            return builder.error(correlationId, status, errorCode).build();
        }

        MemorySegment data = MemorySegment.NULL;
        long payloadSize = segment.byteSize() - HEADER_SIZE;
        if (payloadSize > 0) {
            data = segment.asSlice(HEADER_SIZE, payloadSize);
        }

        return builder.partial(correlationId, status, data).build();
    }

    private static final StructLayout HEADER_LAYOUT = MemoryLayout.structLayout(
        ValueLayout.JAVA_INT.withName("totalSize"),
        ValueLayout.JAVA_INT.withName("correlationId"),
        ValueLayout.JAVA_BYTE.withName("status"),
        ValueLayout.JAVA_BYTE.withName("errorCode"),
        MemoryLayout.paddingLayout(2)
    );

    private static final VarHandle VH_TOTAL_SIZE = 
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("totalSize"));

    private static final VarHandle VH_CORRELATION = 
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("correlationId"));
    private static final VarHandle VH_STATUS = 
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("status"));
    private static final VarHandle VH_ERROR_CODE =
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("errorCode"));

    private static final long HEADER_SIZE = HEADER_LAYOUT.byteSize();
}
