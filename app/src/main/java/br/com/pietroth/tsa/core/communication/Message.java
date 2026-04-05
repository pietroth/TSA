package br.com.pietroth.tsa.core.communication;

public abstract class Message<T extends MessageData> {
    private final byte family;
    private final byte type;
    private final T data;

    public Message(byte family, byte type, T data) {
        this.family = family;
        this.type = type;
        this.data = data;
    }

    public byte getFamily() {
        return family;
    }

    public byte getType() {
        return type;
    }

    public T getData() {
        return data;
    }
}
