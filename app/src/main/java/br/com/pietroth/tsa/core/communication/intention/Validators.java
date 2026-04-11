package br.com.pietroth.tsa.core.communication.intention;

import br.com.pietroth.tsa.core.communication.intention.player.playermove.PlayerMoveValidator;

public class Validators {
    private final IntentionVD intentionVD;

    public Validators(IntentionVD intentionVD) {
        this.intentionVD = intentionVD;
    }

    public void registerValidators() {
        intentionVD.registerValidator((byte)0x01, (byte)0x01, new PlayerMoveValidator());
    }
}
