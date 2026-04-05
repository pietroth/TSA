package br.com.pietroth.tsa.core.communication.event;

import br.com.pietroth.tsa.core.communication.MessageData;

public class Event<T extends MessageData> {
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
