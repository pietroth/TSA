package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.communication.event.EventExecutor;
import br.com.pietroth.tsa.core.game.application.MoveUseCase;

public class PlayerMovedExecutor implements EventExecutor<PlayerMoveData> {
    private final MoveUseCase movementUseCase;                          

    public PlayerMovedExecutor(MoveUseCase movementUseCase) {
        this.movementUseCase = movementUseCase;
    }

    @Override
    public void execute(PlayerMoveData data) {
        System.out.println("Executing PlayerMoved: " + data.sx + ", " + data.sy);
        movementUseCase.execute(data.sx, data.sy);
    }
    
}
