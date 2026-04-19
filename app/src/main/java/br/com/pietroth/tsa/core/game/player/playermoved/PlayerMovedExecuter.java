package br.com.pietroth.tsa.core.game.player.playermoved;

import br.com.pietroth.tsa.core.engine.application.MovementUseCase;
import br.com.pietroth.tsa.core.engine.communication.event.EventExecuter;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveData;

public class PlayerMovedExecuter implements EventExecuter<PlayerMoveData> {
    private final MovementUseCase movementUseCase;                          

    public PlayerMovedExecuter(MovementUseCase movementUseCase) {
        this.movementUseCase = movementUseCase;
    }

    @Override
    public void execute(PlayerMoveData data) {
        System.out.println("Executing PlayerMoved: " + data.sx + ", " + data.sy);
        movementUseCase.execute(data.sx, data.sy);
    }
    
}
