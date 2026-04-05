package br.com.pietroth.tsa.core.communication;

import java.nio.ByteBuffer;

import br.com.pietroth.tsa.core.communication.codec.Codec;
import br.com.pietroth.tsa.core.communication.codec.CodecRegistry;

public class MessageEncoder {

    private final CodecRegistry codecRegistry;

    public MessageEncoder(CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    public <T extends MessageData> byte[] encode(Message<T> message) {
        Codec<? extends MessageData> codec = codecRegistry.get(message.getFamily(), message.getType());

        int payloadSize = codec.size();
        int totalSize = 4 + 2 + payloadSize; // 4 bytes for length prefix + 2 bytes for event ID + payload size

        ByteBuffer buffer = ByteBuffer.allocate(totalSize);

        buffer.position(4); // Reserve space for the length prefix

        short eventId = (short)((message.getFamily() << 8) | (message.getType() & 0xFF));
        buffer.putShort(eventId);

        @SuppressWarnings("unchecked")
        Codec<MessageData> c = (Codec<MessageData>) codec;
        c.encode(buffer, message.getData());

        buffer.putInt(0, totalSize); // Write the length prefix at the reserved space

        byte[] raw = new byte[buffer.position()];
        buffer.flip();
        buffer.get(raw);
        return raw;
    }
}