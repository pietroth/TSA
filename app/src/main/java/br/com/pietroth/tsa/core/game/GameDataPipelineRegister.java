package br.com.pietroth.tsa.core.game;

import br.com.pietroth.tsa.core.engine.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.engine.runtime.ComponentResolver;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;
import br.com.pietroth.tsa.core.game.physics.movement.EntityMoveCodec;
import br.com.pietroth.tsa.core.game.physics.movement.EntityMoveValidator;
import br.com.pietroth.tsa.core.game.physics.movement.MoveUseCase;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveCodec;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveUseCase;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveValidator;

public final class GameDataPipelineRegister {
    private GameDataPipelineRegister() {}

    public static void registerAll(ComponentResolver pipeline, ECSRuntime ecsRuntime) {
        pipeline.register(
            MIDFGlossary.Player.getGlobalId(),
            MIDFGlossary.Player.PLAYER_MOVE.getId(),
            new PlayerMoveValidator(),
            new PlayerMoveUseCase(ecsRuntime.getContainer()),
            new PlayerMoveCodec()
        );

        pipeline.register(
            MIDFGlossary.Physics.getGlobalId(),
            MIDFGlossary.Physics.ENTITY_MOVE.getId(),
            new EntityMoveValidator(),
            new MoveUseCase(ecsRuntime.getContainer()),
            new EntityMoveCodec()
        );
    }
}
