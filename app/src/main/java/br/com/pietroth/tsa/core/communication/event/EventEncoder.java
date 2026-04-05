package br.com.pietroth.tsa.core.communication.event;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.communication.event.codec.Codec;
import br.com.pietroth.tsa.core.communication.event.codec.CodecRegistry;

public class EventEncoder {

    private final CodecRegistry codecRegistry;

    public EventEncoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    public byte[] encode(Event<? extends EventData> event) {
        @SuppressWarnings("unchecked")
        Codec<EventData> codec =
            (Codec<EventData>) codecRegistry.get(event.getFamily(), event.getType());

        int payloadSize = codec.size();
        int totalSize = 4 + 2 + payloadSize; // 4 bytes for length prefix + 2 bytes for event ID + payload size

        ByteBuffer buffer = ByteBuffer.allocate(totalSize);

        buffer.position(4); // Reserve space for the length prefix

        short eventId = (short)((event.getFamily() << 8) | (event.getType() & 0xFF));
        buffer.putShort(eventId);

        codec.encode(buffer, event.getData());

        buffer.putInt(0, totalSize); // Write the length prefix at the reserved space

        byte[] raw = new byte[buffer.position()];
        buffer.flip();
        buffer.get(raw);
        return raw;
    }
}