package br.com.pietroth.tsa.core.event;

public class Event<T extends EventData> {
    private final byte family;
    private final byte type;
    private final T data;

    public Event(byte family, byte type, T data) {
        this.family = family;
        this.type = type;
        this.data = data;
    }

    public byte getFamily() {
        return this.family;
    }

    public byte getType() {
        return this.type;
    }

    public T getData() {
        return this.data;
    }
}
