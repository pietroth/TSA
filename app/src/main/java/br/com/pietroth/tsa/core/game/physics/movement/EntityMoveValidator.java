package br.com.pietroth.tsa.core.game.physics.movement;

import br.com.pietroth.tsa.core.engine.communication.intention.Intention;
import br.com.pietroth.tsa.core.engine.communication.validator.Validator;

public class EntityMoveValidator implements Validator<MoveData> {
    @Override
    public int validate(Intention<MoveData> intention) {
        return 0;
    }
}
