package br.com.pietroth.tsa.core.event;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.event.codec.CodecRegistry;
import br.com.pietroth.tsa.core.event.codec.EventCodec;

public class EventEncoder {

    private final CodecRegistry codecRegistry;

    public EventEncoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    public byte[] encode(Event<? extends EventData> event) {
        ByteBuffer buffer = ByteBuffer.allocate(1024); 

        short eventId = (short)((event.getFamily() << 8) | (event.getType() & 0xFF));
        buffer.putShort(eventId);

        @SuppressWarnings("unchecked")
        EventCodec<EventData> codec = (EventCodec<EventData>) codecRegistry.get(event.getFamily(), event.getType());

        codec.encode(buffer, event.getData());

        byte[] raw = new byte[buffer.position()];
        buffer.flip();
        buffer.get(raw);
        return raw;
    }
}