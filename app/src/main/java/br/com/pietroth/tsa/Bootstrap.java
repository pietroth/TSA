package br.com.pietroth.tsa;

import br.com.pietroth.tsa.core.communication.event.codec.CodecRegistry;
import br.com.pietroth.tsa.core.ecs.ECSRuntime;

public class Bootstrap {
    private final ECSRuntime ecsRuntime;
    private final CodecRegistry registry;

    public Bootstrap(Builder builder) {
        this.ecsRuntime = builder.ecsRuntime;
        this.registry = builder.registry;
    }

    public ECSRuntime getEcsRuntime() {
        return ecsRuntime;
    }

    public CodecRegistry getCodecRegistry() {
        return registry;
    }

    public static class Builder {
        private ECSRuntime ecsRuntime;
        private CodecRegistry registry;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public Builder codecRegistry(CodecRegistry registry) {
            this.registry = registry;
            return this;
        }

        public Bootstrap build() {
            if (ecsRuntime == null) throw new IllegalStateException("ECSRuntime is required");
            if (registry == null) throw new IllegalStateException("CodecRegistry is required");
            return new Bootstrap(this);
        }
    }
}
