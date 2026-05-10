package br.com.pietroth.tsa.core.game.physics.movement;

import br.com.pietroth.tsa.core.engine.communication.intention.Intention;
import br.com.pietroth.tsa.core.engine.communication.validator.Validator;
import br.com.pietroth.tsa.core.engine.communication.validator.ValidatorResponse;

public class EntityMoveValidator implements Validator<MoveData> {
    @Override
    public ValidatorResponse validate(Intention<MoveData> intention) {
        return ValidatorResponse.success();
    }
}
