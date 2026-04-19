package br.com.pietroth.tsa.core.communication.event;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.communication.MIDFData;
import br.com.pietroth.tsa.core.communication.codec.Codec;
import br.com.pietroth.tsa.core.communication.codec.CodecRegistry;

public class EventDecoder {
    private final CodecRegistry codecRegistry;

    public EventDecoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    @SuppressWarnings("unchecked")
    public <T extends MIDFData> Event<T> decode(byte[] raw) {
        if (raw == null) {
            throw new IllegalArgumentException("raw cannot be null");
        }

        ByteBuffer buffer = ByteBuffer.wrap(raw);

        if (buffer.remaining() < 6) {
            throw new IllegalStateException(
                "Corrupted MIDF: too small to contain length prefix and eventId"
            );
        }

        int totalSize = buffer.getInt();
        if (totalSize != raw.length) {
            throw new IllegalStateException(
                "Corrupted MIDF: declared size " + totalSize +
                " does not match actual size " + raw.length
            );
        }

        short eventId = buffer.getShort();
        byte family = (byte) ((eventId >> 8) & 0xFF);
        byte type = (byte) (eventId & 0xFF);

        Codec<?> rawCodec = codecRegistry.get(eventId);
        if (rawCodec == null) {
            throw new IllegalStateException("No codec found for eventId: " + eventId);
        }

        Codec<T> codec = (Codec<T>) rawCodec;
        T data = codec.decode(buffer);

        if (buffer.hasRemaining()) {
            throw new IllegalStateException(
                "Corrupted MIDF: payload decoder did not consume all bytes, " +
                buffer.remaining() + " bytes left"
            );
        }

        return new Event<>(family, type, data, 0, null);
    }
}
