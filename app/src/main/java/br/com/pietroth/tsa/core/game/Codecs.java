package br.com.pietroth.tsa.core.game;

import br.com.pietroth.tsa.core.engine.communication.codec.CodecRegistry;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveCodec;

public class Codecs {
    private final CodecRegistry registry;
    private final PlayerMoveCodec playerMovementCodec;

    public Codecs(Builder builder) {
        this.registry = builder.registry;
        this.playerMovementCodec = builder.playerMovementCodec;
    }

    public void registerCodecs() {
        this.registry.register(
            (byte) MIDFGlossary.Player.getGlobalId(),
            (byte) MIDFGlossary.Player.PLAYER_MOVED.getId(),
            this.playerMovementCodec
        );
    }

    public Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PlayerMoveCodec playerMovementCodec;
        private CodecRegistry registry;

        public Builder playerMovementCodec(PlayerMoveCodec playerMovementCodec) {
            this.playerMovementCodec = playerMovementCodec;
            return this;
        }

        public Builder registry(CodecRegistry registry) {
            this.registry = registry;
            return this;
        }

        public Codecs build() {
            if (playerMovementCodec == null) throw new IllegalStateException("PlayerMovementCodec is required");
            if (registry == null) throw new IllegalStateException("CodecRegistry is required");
            return new Codecs(this);
        }
    }

}
