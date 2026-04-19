package br.com.pietroth.tsa.core.engine.communication.codec;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public interface Codec<T extends MIDFData> {
    int size();
    int size(T data);
    void encode(ByteBuffer buffer, T data);
    T decode(ByteBuffer buffer);
}
