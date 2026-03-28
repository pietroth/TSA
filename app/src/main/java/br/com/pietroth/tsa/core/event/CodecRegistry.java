package br.com.pietroth.tsa.core.event;

import java.util.HashMap;
import java.util.Map;

public class CodecRegistry {
    private final Map<Short, EventCodec<? extends EventData>> registry = new HashMap<>();

    public void register(byte family, byte type, EventCodec<? extends EventData> codec) {
        short eventId = (short)((family << 8) | (type & 0xFF));
        registry.put(eventId, codec);
    }

    public EventCodec<? extends EventData> get(short eventId) {
        return registry.get(eventId);
    }

    public EventCodec<? extends EventData> get(byte family, byte type) {
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