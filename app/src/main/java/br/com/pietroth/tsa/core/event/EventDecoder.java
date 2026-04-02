package br.com.pietroth.tsa.core.event;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.event.codec.CodecRegistry;
import br.com.pietroth.tsa.core.event.codec.Codec;

public class EventDecoder {

    private final CodecRegistry codecRegistry;

    public EventDecoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    public Event<? extends EventData> decode(byte[] raw) {
        if (raw == null) {
            throw new IllegalArgumentException("raw cannot be null");
        }

        ByteBuffer buffer = ByteBuffer.wrap(raw);

        if (buffer.remaining() < 6) {
            throw new IllegalStateException(
                "Corrupted message: too small to contain length prefix and eventId"
            );
        }

        int totalSize = buffer.getInt(); 

        if (totalSize != raw.length) {
            throw new IllegalStateException(
                "Corrupted message: declared size " + totalSize +
                " does not match actual size " + raw.length
            );
        }

        short eventId = buffer.getShort();

        byte family = (byte) ((eventId >> 8) & 0xFF);
        byte type = (byte) (eventId & 0xFF);

        Codec<?> codec = codecRegistry.get(eventId);
        if (codec == null) {
            throw new IllegalStateException("No codec found for eventId: " + eventId);
        }

        Object payload = codec.decode(buffer);

        if (buffer.hasRemaining()) {
            throw new IllegalStateException(
                "Corrupted message: payload decoder did not consume all bytes, " +
                buffer.remaining() + " bytes left"
            );
        }

        return new Event<>(family, type, EventData.class.cast(payload));
    }
}
