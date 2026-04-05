package br.com.pietroth.tsa.core.communication.intention.player.playermove;

import br.com.pietroth.tsa.core.communication.intention.Intention;
import br.com.pietroth.tsa.core.communication.intention.IntentionValidator;
import br.com.pietroth.tsa.core.communication.player.playermoved.PlayerMovementData;

public class PlayerMoveValidator implements IntentionValidator<PlayerMovementData> {
    public int validate(Intention<PlayerMovementData> intention) {
        return 1;
    }
}