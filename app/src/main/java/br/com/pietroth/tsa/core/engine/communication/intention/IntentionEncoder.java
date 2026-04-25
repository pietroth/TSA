package br.com.pietroth.tsa.core.engine.communication.intention;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import br.com.pietroth.tsa.core.engine.communication.codec.CodecRegistry;

public class IntentionEncoder {
    private final CodecRegistry codecRegistry;

    public IntentionEncoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    @SuppressWarnings("unchecked")
    public <T extends MIDFData> byte[] encode(Intention<T> intention) {
        Codec<T> codec = (Codec<T>) codecRegistry.get(intention.getFamily(), intention.getType());
        
        // 4 (length) + 4 (correlationId) + 2 (intentionId) + payload
        int payloadSize = codec.size();
        int totalSize = 10 + payloadSize; 

        byte[] raw = new byte[totalSize];
        int offset = 0;

        // Total Size (4 bytes)
        raw[offset++] = (byte) (totalSize >> 24);
        raw[offset++] = (byte) (totalSize >> 16);
        raw[offset++] = (byte) (totalSize >> 8);
        raw[offset++] = (byte) totalSize;

        // Correlation ID (4 bytes)
        int correlationId = intention.getCorrelationId();
        raw[offset++] = (byte) (correlationId >> 24);
        raw[offset++] = (byte) (correlationId >> 16);
        raw[offset++] = (byte) (correlationId >> 8);
        raw[offset++] = (byte) correlationId;

        // Intention ID (Family + Type = 2 bytes)
        int intentionId = ((intention.getFamily() << 8) | (intention.getType() & 0xFF));
        raw[offset++] = (byte) (intentionId >> 8);
        raw[offset++] = (byte) intentionId;
        
        codec.encode(raw, offset, intention.getData());

        return raw;
    }
}
