package br.com.pietroth.tsa.core.engine.communication.intention;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import br.com.pietroth.tsa.core.engine.communication.codec.CodecRegistry;

public class IntentionDecoder {

    private final CodecRegistry codecRegistry;

    public IntentionDecoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    @SuppressWarnings("unchecked")
    public <T extends MIDFData> Intention<T> decode(byte[] raw, int originId) {
        MemorySegment segment = MemorySegment.ofArray(raw);

        int correlationId = (int) VH_CORRELATION.get(segment, 0L);
        short intentionId = (short) VH_INTENTION.get(segment, 0L);

        Codec<T> codec = (Codec<T>) codecRegistry.get(intentionId);

        T data = codec.decode(raw, (int) HEADER_SIZE);

        return new Intention<>(
            (byte) (intentionId >> 8), // Family
            (byte) intentionId,        // Type
            data,
            correlationId,
            originId
        );
    }

    private static final StructLayout INTENTION_HEADER = MemoryLayout.structLayout(
        ValueLayout.JAVA_INT.withName("correlationId"),
        ValueLayout.JAVA_SHORT.withName("intentionId")
    );

    private static final VarHandle VH_CORRELATION = 
        INTENTION_HEADER.varHandle(MemoryLayout.PathElement.groupElement("correlationId"));

    private static final VarHandle VH_INTENTION =
        INTENTION_HEADER.varHandle(MemoryLayout.PathElement.groupElement("intentionId"));
    
    private static final long HEADER_SIZE = INTENTION_HEADER.byteSize();

}
