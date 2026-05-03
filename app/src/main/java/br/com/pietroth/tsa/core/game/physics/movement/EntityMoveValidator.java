package br.com.pietroth.tsa.core.game.physics.movement;

import br.com.pietroth.tsa.core.engine.communication.intention.Intention;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionValidator;

public class EntityMoveValidator implements IntentionValidator<MoveData> {
    @Override
    public int validate(Intention<MoveData> intention) {
        return 0;
    }
}
