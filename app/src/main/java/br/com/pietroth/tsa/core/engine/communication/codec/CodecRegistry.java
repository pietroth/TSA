package br.com.pietroth.tsa.core.engine.communication.codec;

import java.util.HashMap;
import java.util.Map;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public class CodecRegistry {
    private final Map<Short, Codec<? extends MIDFData>> registry = new HashMap<>();

    public <T extends MIDFData> void register(byte family, byte type, Codec<T> codec) {
        short MIDFId = (short)((family << 8) | (type & 0xFF));
        registry.put(MIDFId, codec);
    }

    public Codec<? extends MIDFData> get(short MIDFId) {
        return registry.get(MIDFId);
    }

    public Codec<? extends MIDFData> get(byte family, byte type) {
        short MIDFId = (short)((family << 8) | (type & 0xFF));
        return registry.get(MIDFId);
    }

    public boolean contains(byte family, byte type) {
        short MIDFId = (short)((family << 8) | (type & 0xFF));
        return registry.containsKey(MIDFId);
    }

    public void unregister(byte family, byte type) {
        short MIDFId = (short)((family << 8) | (type & 0xFF));
        registry.remove(MIDFId);
    }
}