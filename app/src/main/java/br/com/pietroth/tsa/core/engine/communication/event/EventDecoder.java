package br.com.pietroth.tsa.core.engine.communication.event;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import br.com.pietroth.tsa.core.engine.communication.codec.CodecRegistry;

public class EventDecoder {
    private final CodecRegistry codecRegistry;

    public EventDecoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    @SuppressWarnings("unchecked")
    public <T extends MIDFData> Event<T> decode(byte[] raw) {
        int offset = 0;
        offset += 4; // Skip total size

        int eventId =
            ((raw[offset] & 0xFF) << 8) |
            (raw[offset + 1] & 0xFF);

        offset += 2;

        Codec<T> codec = (Codec<T>) codecRegistry.get((short) eventId);
        T data = codec.decode(raw, offset);

        return new Event<>(
            (byte) (eventId >> 8), // Family id
            (byte) eventId, // event Id
            data,
            0,
            null
        );
    }
}
