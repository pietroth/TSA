package br.com.pietroth.tsa.core.event;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.event.codec.CodecRegistry;
import br.com.pietroth.tsa.core.event.codec.Codec;

public class EventEncoder {

    private final CodecRegistry codecRegistry;

    public EventEncoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    public byte[] encode(Event<? extends EventData> event) {
        ByteBuffer buffer = ByteBuffer.allocate(1024); 

        buffer.position(4); // Reserve space for the length prefix

        short eventId = (short)((event.getFamily() << 8) | (event.getType() & 0xFF));
        buffer.putShort(eventId);

        @SuppressWarnings("unchecked")
        Codec<EventData> codec = (Codec<EventData>) codecRegistry.get(event.getFamily(), event.getType());

        codec.encode(buffer, event.getData());

        int length = buffer.position() - 4; // Calculate the length of the event data
        buffer.putInt(0, length); // Write the length prefix at the reserved space

        byte[] raw = new byte[buffer.position()];
        buffer.flip();
        buffer.get(raw);
        return raw;
    }
}