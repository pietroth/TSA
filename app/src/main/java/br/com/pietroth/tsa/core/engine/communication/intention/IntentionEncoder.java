package br.com.pietroth.tsa.core.engine.communication.intention;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;

public class IntentionEncoder {
    public <T extends MIDFData> MemorySegment encode(Arena arena, Intention<T> intention, Codec<T> codec) {
        // 4 (length) + 4 (correlationId) + 2 (intentionId) + 2 (padding) + payload
        int payloadSize = codec.size();
        int totalSize = (int) HEADER_SIZE + payloadSize;

        MemorySegment segment = arena.allocate(totalSize);

        // 0L : Automatics Offsets
        VH_TOTAL_SIZE.set(segment, 0L, totalSize);
        VH_CORRELATION.set(segment, 0L, intention.getCorrelationId());

        short intentionId = (short) ((intention.getFamily() << 8) | (intention.getType() & 0xFF));
        VH_INTENTION.set(segment, 0L, intentionId);

        MemorySegment bodySegment = segment.asSlice(HEADER_SIZE);
        codec.encode(bodySegment, intention.getData());

        return segment;
    }

    private final static StructLayout HEADER_LAYOUT = MemoryLayout.structLayout(
        ValueLayout.JAVA_INT.withName("totalSize"),
        ValueLayout.JAVA_INT.withName("correlationId"),
        ValueLayout.JAVA_SHORT.withName("intentionId"),
        MemoryLayout.paddingLayout(2)
    );

    private final static VarHandle VH_TOTAL_SIZE = 
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("totalSize"));

    private final static VarHandle VH_CORRELATION =
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("correlationId"));

    private final static VarHandle VH_INTENTION =
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("intentionId"));

    private final static long HEADER_SIZE = HEADER_LAYOUT.byteSize();

}
