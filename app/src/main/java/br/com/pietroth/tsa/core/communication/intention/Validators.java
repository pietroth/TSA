package br.com.pietroth.tsa.core.communication.intention;

import br.com.pietroth.tsa.core.communication.MIDFIdentifier;
import br.com.pietroth.tsa.core.communication.intention.player.playermove.PlayerMoveValidator;

public class Validators {
    private final IntentionVD intentionVD;
    private final PlayerMoveValidator playerMoveValidator;

    public Validators(Builder builder) {
        this.intentionVD = builder.intentionVD;
        this.playerMoveValidator = builder.playerMoveValidator;
    }

    public void registerValidators() {
        intentionVD.registerValidator
            (MIDFIdentifier.Player.getGlobalId(), 
            MIDFIdentifier.Player.PLAYER_MOVED.getId(), 
            playerMoveValidator);
    }

    public static class Builder {
        private IntentionVD intentionVD;
        private PlayerMoveValidator playerMoveValidator;

        public Builder intentionVD(IntentionVD intentionVD) {
            this.intentionVD = intentionVD;
            return this;
        }

        public Builder playerMoveValidator(PlayerMoveValidator playerMoveValidator) {
            this.playerMoveValidator = playerMoveValidator;
            return this;
        }

        public Validators build() {
            if (intentionVD == null) throw new IllegalStateException("IntentionVD is required");
            if (playerMoveValidator == null) throw new IllegalStateException("PlayerMoveValidator is required");    
            return new Validators(this);
        }
    }
}
