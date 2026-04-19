package br.com.pietroth.tsa.core.engine.network.client;

public class ClientId {
    private final int id;

    public ClientId(int id) {
        if (validate(id)) {
            this.id = id;
        }

        throw new ExceptionInInitializerError();
    }

    public boolean validate(int id) { return true; }

    public int getId() { return this.id; }
}
