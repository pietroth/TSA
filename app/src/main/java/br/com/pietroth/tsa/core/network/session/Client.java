package br.com.pietroth.tsa.core.network.session;

import br.com.pietroth.tsa.core.network.transport.Connection;

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
}
