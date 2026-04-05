package br.com.pietroth.tsa.core.communication.event.codec;

import java.util.HashMap;
import java.util.Map;

import br.com.pietroth.tsa.core.communication.event.EventData;

public class CodecRegistry {
    private final Map<Short, Codec<? extends EventData>> registry = new HashMap<>();

    public void register(byte family, byte type, Codec<? extends EventData> codec) {
        short eventId = (short)((family << 8) | (type & 0xFF));
        registry.put(eventId, codec);
    }

    public Codec<? extends EventData> get(short eventId) {
        return registry.get(eventId);
    }

    public Codec<? extends EventData> get(byte family, byte type) {
        short eventId = (short)((family << 8) | (type & 0xFF));
        return registry.get(eventId);
    }

    public boolean contains(byte family, byte type) {
        short eventId = (short)((family << 8) | (type & 0xFF));
        return registry.containsKey(eventId);
    }

    public void unregister(byte family, byte type) {
        short eventId = (short)((family << 8) | (type & 0xFF));
        registry.remove(eventId);
    }
}