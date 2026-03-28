package br.com.pietroth.tsa.core.event;

import java.nio.ByteBuffer;

public interface EventCodec<T extends EventData> {
    void encode(ByteBuffer buffer, T data);
    T decode(ByteBuffer buffer);
}
