package br.com.pietroth.tsa.core.communication.event.player.playermoved;

import br.com.pietroth.tsa.core.application.MovementUseCase;
import br.com.pietroth.tsa.core.communication.event.EventExecuter;
import br.com.pietroth.tsa.core.communication.player.playermoved.PlayerMovementData;

public class PlayerMovedExecuter implements EventExecuter<PlayerMovementData> {
    private final MovementUseCase movementUseCase;                          

    public PlayerMovedExecuter(MovementUseCase movementUseCase) {
        this.movementUseCase = movementUseCase;
    }

    @Override
    public void execute(PlayerMovementData data) {
        movementUseCase.execute(data.sx, data.sy);
    }
    
}
