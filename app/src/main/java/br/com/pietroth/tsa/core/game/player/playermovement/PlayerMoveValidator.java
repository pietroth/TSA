package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.communication.intention.Intention;
import br.com.pietroth.tsa.core.engine.communication.validator.Validator;
import br.com.pietroth.tsa.core.engine.communication.validator.ValidatorResponse;

public class PlayerMoveValidator implements Validator<PlayerMoveData> {
    public ValidatorResponse validate(Intention<PlayerMoveData> intention) {
        return null;
    }
}