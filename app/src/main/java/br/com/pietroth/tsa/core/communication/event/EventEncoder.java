package br.com.pietroth.tsa.core.communication.event;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.communication.event.codec.Codec;
import br.com.pietroth.tsa.core.communication.event.codec.CodecRegistry;
import br.com.pietroth.tsa.core.communication.MessageData;

public class EventEncoder {

    private final CodecRegistry codecRegistry;

    public EventEncoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    public byte[] encode(Event<? extends MessageData> event) {
        Codec<? extends MessageData> codec = codecRegistry.get(event.getFamily(), event.getType());

        int payloadSize = codec.size();
        int totalSize = 4 + 2 + payloadSize; // 4 bytes for length prefix + 2 bytes for event ID + payload size

        ByteBuffer buffer = ByteBuffer.allocate(totalSize);

        buffer.position(4); // Reserve space for the length prefix

        short eventId = (short)((event.getFamily() << 8) | (event.getType() & 0xFF));
        buffer.putShort(eventId);

        @SuppressWarnings("unchecked")
        Codec<MessageData> c = (Codec<MessageData>) codec;
        c.encode(buffer, event.getData());

        buffer.putInt(0, totalSize); // Write the length prefix at the reserved space

        byte[] raw = new byte[buffer.position()];
        buffer.flip();
        buffer.get(raw);
        return raw;
    }
}