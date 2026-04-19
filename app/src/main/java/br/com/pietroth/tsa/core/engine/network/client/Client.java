package br.com.pietroth.tsa.core.engine.network.client;

import br.com.pietroth.tsa.core.engine.network.transport.Connection;

public class Client {
    private final int id;
    private final Connection connection;

    public Client(Builder builder) {
        this.id = builder.id;
        this.connection = builder.connection;
    }

    public int getId() {
        return id;
    }

    public Connection getConnection() {
        return connection;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private Connection connection;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder connection(Connection connection) {
            this.connection = connection;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client other = (Client) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
