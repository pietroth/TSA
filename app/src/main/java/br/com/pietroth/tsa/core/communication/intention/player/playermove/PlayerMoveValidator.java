package br.com.pietroth.tsa.core.communication.intention.player.playermove;

import br.com.pietroth.tsa.core.communication.intention.Intention;
import br.com.pietroth.tsa.core.communication.player.playermoved.PlayerMovementData;

public class PlayerMoveValidator {
    public boolean validate(Intention<PlayerMovementData> intention) {
        return true;
    }
}