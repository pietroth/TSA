package br.com.pietroth.tsa;

public class Bootstrap {
    public Bootstrap(Builder builder) {

    }

    public static class Builder {
        public Builder() {}

        public Bootstrap build() {
            return new Bootstrap(this);
        }
    }
}
