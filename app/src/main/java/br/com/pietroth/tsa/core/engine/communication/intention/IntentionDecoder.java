package br.com.pietroth.tsa.core.engine.communication.intention;

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
        int offset = 0;

        int correlationId = 
            (raw[offset++] & 0xFF) << 24 |
            (raw[offset++] & 0xFF) << 16 |
            (raw[offset++] & 0xFF) << 8 |
            (raw[offset++] & 0xFF);

        int intentionId = 
            ((raw[offset++] & 0xFF) << 8) |
            (raw[offset++] & 0xFF);

        Codec<T> codec = (Codec<T>) codecRegistry.get((short) intentionId);
        T data = codec.decode(raw, offset);

        return new Intention<>(
            (byte) (intentionId >> 8), // Family
            (byte) intentionId,        // Type
            data,
            correlationId,
            originId
        );
    }
}
