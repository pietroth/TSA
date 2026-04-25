package br.com.pietroth.tsa.core.engine.communication;

import br.com.pietroth.tsa.core.engine.communication.codec.Codec;
import br.com.pietroth.tsa.core.engine.communication.codec.CodecRegistry;

public class MIDFEncoder {

    private final CodecRegistry codecRegistry;

    public MIDFEncoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    @SuppressWarnings("unchecked")
    public <T extends MIDFData> byte[] encode(MIDF<T> MIDF) {
        Codec<T> codec = (Codec<T>) codecRegistry.get(MIDF.getFamily(), MIDF.getType());
        if (codec == null) {
            throw new RuntimeException("Codec not found. Family: " + MIDF.getFamily() + ", Type: " + MIDF.getType());
        }

        int payloadSize = codec.size();
        int totalSize = 4 + 2 + payloadSize;

        byte[] raw = new byte[totalSize];
        int offset = 0;

        raw[offset++] = (byte) (totalSize >> 24);
        raw[offset++] = (byte) (totalSize >> 16);
        raw[offset++] = (byte) (totalSize >> 8);
        raw[offset++] = (byte) totalSize;

        int MIDFId = ((MIDF.getFamily() << 8) | (MIDF.getType() & 0xFF));
        raw[offset++] = (byte) (MIDFId >> 8);
        raw[offset++] = (byte) MIDFId;

        codec.encode(raw, offset, MIDF.getData());
        return raw;
    }
}