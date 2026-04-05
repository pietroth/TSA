package br.com.pietroth.tsa.core.communication.message;

public abstract class Message<T extends Object> {
    private final String family;
    private final String type;
    private final T data;

    public Message(String family, String type, T data) {
        this.family = family;
        this.type = type;
        this.data = data;
    }

    public String getFamily() {
        return family;
    }

    public String getType() {
        return type;
    }

    public T getData() {
        return data;
    }
}
