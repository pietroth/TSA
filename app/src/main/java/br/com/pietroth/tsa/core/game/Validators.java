package br.com.pietroth.tsa.core.game;

import br.com.pietroth.tsa.core.engine.communication.intention.IntentionVD;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveValidator;

public final class Validators {

    public static void registerAll(IntentionVD intentionVD, PlayerMoveValidator playerMoveValidator) {
        if (intentionVD == null) {
            throw new IllegalStateException("IntentionVD is required");
        }
        if (playerMoveValidator == null) {
            throw new IllegalStateException("PlayerMoveValidator is required");
        }

        intentionVD.registerValidator(
            MIDFGlossary.Player.getGlobalId(),
            MIDFGlossary.Player.PLAYER_MOVED.getId(),
            playerMoveValidator
        );
    }
}