package br.com.pietroth.tsa.core.communication.intention;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.communication.MIDF;
import br.com.pietroth.tsa.core.communication.MIDFData;
import br.com.pietroth.tsa.core.communication.codec.Codec;
import br.com.pietroth.tsa.core.communication.codec.CodecRegistry;

public class IntentionEncoder {
    private final CodecRegistry codecRegistry;

    public IntentionEncoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    public <T extends MIDFData> byte[] encode(Intention<T> intention) {
        Codec<? extends MIDFData> codec = codecRegistry.get(intention.getFamily(), intention.getType());

        int payloadSize = codec.size();
        int totalSize = 4 + 4 + 2 + payloadSize; // 4 bytes for correlationId + 4 bytes for length prefix + 2 bytes for event ID + payload size

        ByteBuffer buffer = ByteBuffer.allocate(totalSize);

        buffer.position(4); // Reserve space for the length prefix

        int correlationId = intention.getCorrelationId();
        short intentionId = (short)((intention.getFamily() << 8) | (intention.getType() & 0xFF));
        
        buffer.putInt(correlationId);
        buffer.putShort(intentionId);

        @SuppressWarnings("unchecked")
        Codec<MIDFData> c = (Codec<MIDFData>) codec;
        c.encode(buffer, intention.getData());

        buffer.putInt(0, totalSize); // Write the length prefix at the reserved space

        byte[] raw = new byte[buffer.position()];
        buffer.flip();
        buffer.get(raw);
        return raw;
    }
}
