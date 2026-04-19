package br.com.pietroth.tsa.core.engine.network.client;

import java.util.concurrent.atomic.AtomicInteger;

public class ClientId {
    private final AtomicInteger id;

    public ClientId(AtomicInteger id) {
        if (validate(id)) {
            this.id = id;
        }

        throw new ExceptionInInitializerError();
    }

    public boolean validate(AtomicInteger id) { return true; }

    public AtomicInteger getId() { return this.id; }
}
