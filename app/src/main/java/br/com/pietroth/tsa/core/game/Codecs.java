package br.com.pietroth.tsa.core.game;

import br.com.pietroth.tsa.core.engine.communication.codec.CodecRegistry;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveCodec;

public final class Codecs {

    public static void registerAll(CodecRegistry registry, PlayerMoveCodec playerMovementCodec) {
        if (registry == null) {
            throw new IllegalStateException("CodecRegistry is required");
        }
        if (playerMovementCodec == null) {
            throw new IllegalStateException("PlayerMoveCodec is required");
        }

        registry.register(
            (byte) MIDFGlossary.Player.getGlobalId(),
            (byte) MIDFGlossary.Player.PLAYER_MOVE.getId(),
            playerMovementCodec
        );
    }
}