package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.communication.event.EventExecutor;

public class PlayerMovedExecutor implements EventExecutor<PlayerMoveData> {
    private final PlayerMoveUseCase useCase;                          

    public PlayerMovedExecutor(PlayerMoveUseCase movementUseCase) {
        this.useCase = movementUseCase;
    }

    @Override
    public void execute(PlayerMoveData data) {
        System.out.println("Executing PlayerMoved: " + data.sx + ", " + data.sy);
        useCase.execute(data);
    }
    
}
