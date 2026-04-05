package br.com.pietroth.tsa.core.communication.codec;

import java.util.HashMap;
import java.util.Map;

import br.com.pietroth.tsa.core.communication.MessageData;

public class CodecRegistry {
    private final Map<Short, Codec<?>> registry = new HashMap<>();

    public <T extends MessageData> void register(byte family, byte type, Codec<T> codec) {
        short eventId = (short)((family << 8) | (type & 0xFF));
        registry.put(eventId, codec);
    }

    public Codec<? extends MessageData> get(short eventId) {
        return registry.get(eventId);
    }

    public Codec<? extends MessageData> get(byte family, byte type) {
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