package br.com.pietroth.tsa.core.engine.communication.intention.player.playermove;

import br.com.pietroth.tsa.core.engine.communication.intention.Intention;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionValidator;
import br.com.pietroth.tsa.core.engine.communication.player.playermovement.PlayerMoveData;

public class PlayerMoveValidator implements IntentionValidator<PlayerMoveData> {
    public int validate(Intention<PlayerMoveData> intention) {
        return 1;
    }
}