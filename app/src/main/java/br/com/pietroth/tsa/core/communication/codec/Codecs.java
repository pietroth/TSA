package br.com.pietroth.tsa.core.communication.codec;

import br.com.pietroth.tsa.core.communication.MessageIdentifier;
import br.com.pietroth.tsa.core.communication.player.playermovement.PlayerMoveCodec;

public class Codecs {

    private final PlayerMoveCodec playerMovementCodec;

    public Codecs(Builder builder) {
        this.playerMovementCodec = builder.playerMovementCodec;
    }

    public void registerCodecs(CodecRegistry registry) {
        registry.register(
            (byte) MessageIdentifier.Player.getGlobalId(),
            (byte) MessageIdentifier.Player.PLAYER_MOVED.getId(),
            this.playerMovementCodec
        );
    }

    public Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PlayerMoveCodec playerMovementCodec;

        public Builder playerMovementCodec(PlayerMoveCodec playerMovementCodec) {
            this.playerMovementCodec = playerMovementCodec;
            return this;
        }

        public Codecs build() {
            if (playerMovementCodec == null) throw new IllegalStateException("PlayerMovementCodec is required");
            return new Codecs(this);
        }
    }

}
