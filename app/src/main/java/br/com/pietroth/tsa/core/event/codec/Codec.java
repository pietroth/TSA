package br.com.pietroth.tsa.core.event.codec;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.event.EventData;

public interface Codec<T extends EventData> {
    int size();
    void encode(ByteBuffer buffer, T data);
    T decode(ByteBuffer buffer);
}
