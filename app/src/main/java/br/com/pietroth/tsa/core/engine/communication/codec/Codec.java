package br.com.pietroth.tsa.core.engine.communication.codec;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public interface Codec<T extends MIDFData> {
    int size();
    int size(T data);
    void encode(byte[] raw, int offset, T data);
    T decode(byte[] raw, int offset);
}
