package br.com.pietroth.tsa.core.communication.event.player.playermoved;

import br.com.pietroth.tsa.core.application.MovementUseCase;
import br.com.pietroth.tsa.core.communication.event.EventExecuter;

public class PlayerMovedExecuter implements EventExecuter<PlayerMovedData> {
    private final MovementUseCase movementUseCase;                          

    public PlayerMovedExecuter(MovementUseCase movementUseCase) {
        this.movementUseCase = movementUseCase;
    }

    @Override
    public void execute(PlayerMovedData data) {
        movementUseCase.execute(data.sx, data.sy);
    }
    
}
