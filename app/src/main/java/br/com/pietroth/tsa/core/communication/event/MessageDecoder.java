package br.com.pietroth.tsa.core.communication.event;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.communication.event.codec.Codec;
import br.com.pietroth.tsa.core.communication.event.codec.CodecRegistry;
import br.com.pietroth.tsa.core.communication.MessageData;
import br.com.pietroth.tsa.core.communication.intention.Intention;

public class MessageDecoder {

    private final CodecRegistry codecRegistry;

    public MessageDecoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    @SuppressWarnings("unchecked")
    public <T extends MessageData> Event<T> decodeEvent(byte[] raw) {
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

        Codec<?> rawCodec = codecRegistry.get(eventId);
        if (rawCodec == null) {
            throw new IllegalStateException("No codec found for eventId: " + eventId);
        }

        Codec<T> codec = (Codec<T>) rawCodec;
        T data = codec.decode(buffer);

        if (buffer.hasRemaining()) {
            throw new IllegalStateException(
                "Corrupted message: payload decoder did not consume all bytes, " +
                buffer.remaining() + " bytes left"
            );
        }

        return new Event<>(family, type, data);
    }

    @SuppressWarnings("unchecked")
    public <T extends MessageData> Intention<T> decodeIntention(byte[] raw) {
        if (raw == null) {
            throw new IllegalArgumentException("raw cannot be null");
        }

        ByteBuffer buffer = ByteBuffer.wrap(raw);

        if (buffer.remaining() < 6) {
            throw new IllegalStateException(
                "Corrupted message: too small to contain length prefix and intentionId"
            );
        }

        int totalSize = buffer.getInt();

        if (totalSize != raw.length) {
            throw new IllegalStateException(
                "Corrupted message: declared size " + totalSize +
                " does not match actual size " + raw.length
            );
        }

        short intentionId = buffer.getShort();
        byte family = (byte) ((intentionId >> 8) & 0xFF);
        byte type = (byte) (intentionId & 0xFF);

        Codec<?> rawCodec = codecRegistry.get(intentionId);
        if (rawCodec == null) {
            throw new IllegalStateException("No codec found for intentionId: " + intentionId);
        }

        Codec<T> codec = (Codec<T>) rawCodec;
        T data = codec.decode(buffer);

        if (buffer.hasRemaining()) {
            throw new IllegalStateException(
                "Corrupted message: payload decoder did not consume all bytes, " +
                buffer.remaining() + " bytes left"
            );
        }

        return new Intention<>(family, type, data);
    }
}