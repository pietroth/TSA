package br.com.pietroth.tsa.core.communication.intention;

public class Intention {
    private final byte id;

    public Intention(byte id) {
        this.id = id;
    }

    public byte getId() {
        return id;
    }
}
