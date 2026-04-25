package br.com.pietroth.tsa.core.game;

import br.com.pietroth.tsa.core.engine.usecase.UseCaseRouter;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;
import br.com.pietroth.tsa.core.game.physics.movement.MoveUseCase;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveUseCase;

public class UseCases {

    public static void registerAll(UseCaseRouter router, MoveUseCase moveUseCase, PlayerMoveUseCase playerMoveUseCase) {
        if (router == null) throw new IllegalStateException("UseCaseRouter is required");
        if (moveUseCase == null) throw new IllegalStateException("MoveUseCase is required");
        if (playerMoveUseCase == null) throw new IllegalStateException("PlayerMoveUseCase is required");

        router.register(
            MIDFGlossary.Physics.getGlobalId(), MIDFGlossary.Physics.ENTITY_MOVE.getId(), moveUseCase);
        router.register(
            MIDFGlossary.Player.getGlobalId(), MIDFGlossary.Player.PLAYER_MOVE.getId(), playerMoveUseCase);
    }
}
