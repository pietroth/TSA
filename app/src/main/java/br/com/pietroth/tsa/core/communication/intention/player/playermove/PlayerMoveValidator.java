package br.com.pietroth.tsa.core.communication.intention.player.playermove;

import br.com.pietroth.tsa.core.communication.intention.Intention;
import br.com.pietroth.tsa.core.communication.intention.IntentionValidator;
import br.com.pietroth.tsa.core.communication.player.playermovement.PlayerMoveData;

public class PlayerMoveValidator implements IntentionValidator<PlayerMoveData> {
    public int validate(Intention<PlayerMoveData> intention) {
        return 1;
    }
}