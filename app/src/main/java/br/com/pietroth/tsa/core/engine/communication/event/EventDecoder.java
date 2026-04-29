package br.com.pietroth.tsa.core.engine.communication.event;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;

public class EventDecoder {
    public <T extends MIDFData> Event<T> decode(MemorySegment segment, Codec<T> codec) {
        short eventId = (short) VH_EVENT_ID.get(segment, 0L);

        MemorySegment bodySegment = segment.asSlice(HEADER_SIZE);
        T data = codec.decode(bodySegment);

        return new Event<>(
            (byte) (eventId >> 8), // Family id
            (byte) eventId, // event Id
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

    private static final VarHandle VH_EVENT_ID =
        HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("eventId"));

    private static final long HEADER_SIZE = HEADER_LAYOUT.byteSize();
}
