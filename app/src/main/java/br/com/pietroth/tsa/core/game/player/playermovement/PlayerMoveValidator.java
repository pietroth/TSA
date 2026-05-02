package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.communication.intention.Intention;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionValidator;

public class PlayerMoveValidator implements IntentionValidator<PlayerMoveData> {
    public int validate(Intention<PlayerMoveData> intention) {
        return 0;
    }
}