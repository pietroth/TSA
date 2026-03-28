package br.com.pietroth.tsa.core.event;

import java.nio.ByteBuffer;

public class EventDecoder {

    private final CodecRegistry codecRegistry;

    public EventDecoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    public Event<?> decode(byte[] raw) {
        ByteBuffer buffer = ByteBuffer.wrap(raw);

        short eventId = buffer.getShort();
        byte family = (byte)((eventId >> 8) & 0xFF);
        byte type   = (byte)(eventId & 0xFF);

        EventCodec<?> codec = codecRegistry.get(eventId);

        Object payload = codec.decode(buffer);

        return new Event<EventData>(family, type, EventData.class.cast(payload));
    }
}
