package br.com.pietroth.tsa.core.engine.communication;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import br.com.pietroth.tsa.core.engine.communication.codec.CodecRegistry;

public class MIDFEncoder {

    private final CodecRegistry codecRegistry;

    public MIDFEncoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    public <T extends MIDFData> byte[] encode(MIDF<T> MIDF) {
        Codec<? extends MIDFData> codec = codecRegistry.get(MIDF.getFamily(), MIDF.getType());

        int payloadSize = codec.size();
        int totalSize = 4 + 2 + payloadSize; // 4 bytes for length prefix + 2 bytes for event ID + payload size

        ByteBuffer buffer = ByteBuffer.allocate(totalSize);

        buffer.position(4); // Reserve space for the length prefix

        short MIDFId = (short)((MIDF.getFamily() << 8) | (MIDF.getType() & 0xFF));
        buffer.putShort(MIDFId);

        @SuppressWarnings("unchecked")
        Codec<MIDFData> c = (Codec<MIDFData>) codec;
        c.encode(buffer, MIDF.getData());

        buffer.putInt(0, totalSize); // Write the length prefix at the reserved space

        byte[] raw = new byte[buffer.position()];
        buffer.flip();
        buffer.get(raw);
        return raw;
    }
}