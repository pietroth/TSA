package br.com.pietroth.tsa.core.engine.communication.codec;

import java.lang.foreign.MemorySegment;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public interface Codec<T extends MIDFData> {
    int size();
    int size(T data);
    void encode(MemorySegment dest, T data);
    T decode(MemorySegment src);
}
