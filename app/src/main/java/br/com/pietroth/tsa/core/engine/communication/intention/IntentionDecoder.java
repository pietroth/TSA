package br.com.pietroth.tsa.core.engine.communication.intention;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;

public class IntentionDecoder {
    public int getId(MemorySegment segment) {
        short id = (short) VH_INTENTION.get(segment, 0L);
        int family = (id >> 8) & 0x3F;
        int type = id & 0x3F;
        return (family << 6) | type;
    }

    public <T extends MIDFData> Intention<T> decode(MemorySegment segment, int originId, Codec<T> codec) {
        int correlationId = (int) VH_CORRELATION.get(segment, 0L);

        MemorySegment dataSegment = segment.asSlice(HEADER_SIZE);
        T data = codec.decode(dataSegment);

        return new Intention<>(
            data,
            correlationId,
            originId
        );
    }

    private static final StructLayout HEADER_LAYOUT = MemoryLayout.structLayout(
        ValueLayout.JAVA_INT.withName("totalSize"),
        ValueLayout.JAVA_INT.withName("correlationId"),
        ValueLayout.JAVA_SHORT.withName("intentionId"),
        MemoryLayout.paddingLayout(2)
    );

    private static final VarHandle VH_CORRELATION = 
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("correlationId"));

    private static final VarHandle VH_INTENTION =
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("intentionId"));
    
    private static final long HEADER_SIZE = HEADER_LAYOUT.byteSize();

}
