package br.com.pietroth.tsa.core.communication.event.codec;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.communication.MessageData;

public interface Codec<T extends MessageData> {
    int size();
    int size(T data);
    void encode(ByteBuffer buffer, T data);
    T decode(ByteBuffer buffer);
}
