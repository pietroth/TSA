package br.com.pietroth.tsa.core.engine.communication.event;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;

public class EventDecoder {
    public <T extends MIDFData> Event<T> decode(MemorySegment segment, Codec<T> codec) {
        MemorySegment bodySegment = segment.asSlice(HEADER_SIZE);
        T data = codec.decode(bodySegment);

        return new Event<>(
            data,
            0,
            null
        );
    }

    private static final StructLayout HEADER_LAYOUT = MemoryLayout.structLayout(
        ValueLayout.JAVA_INT.withName("totalSize"),
        ValueLayout.JAVA_SHORT.withName("eventId"),
        MemoryLayout.paddingLayout(2)
    );

    private static final long HEADER_SIZE = HEADER_LAYOUT.byteSize();
}
