package br.com.pietroth.tsa.core.communication.intention;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.communication.MIDFData;
import br.com.pietroth.tsa.core.communication.codec.Codec;
import br.com.pietroth.tsa.core.communication.codec.CodecRegistry;

public class IntentionDecoder {

    private final CodecRegistry codecRegistry;

    public IntentionDecoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    @SuppressWarnings("unchecked")
    public <T extends MIDFData> Intention<T> decode(byte[] raw) {
        if (raw == null) {
            throw new IllegalArgumentException("raw cannot be null");
        }

        ByteBuffer buffer = ByteBuffer.wrap(raw);

        if (raw.length < 2) {
            throw new IllegalStateException("Corrupted MIDF: missing intentionId");
        }

        if (buffer.remaining() < 6) {
            throw new IllegalStateException(
                "Corrupted MIDF: too small to contain totalSize and intentionId"
            );
        }

        int length = buffer.getInt();
        if (length != raw.length) {
            throw new IllegalStateException(
                "Corrupted MIDF: declared size " + length +
                " does not match actual size " + raw.length
            );
        }

        int correlationId = buffer.getInt();
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
                "Corrupted MIDF: payload decoder did not consume all bytes, " +
                buffer.remaining() + " bytes left"
            );
        }

        return new Intention<>(family, type, data, correlationId);
    }
}
