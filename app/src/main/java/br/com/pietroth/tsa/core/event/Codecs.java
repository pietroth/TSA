package br.com.pietroth.tsa.core.event;

import br.com.pietroth.tsa.core.event.player.playermoved.PlayerMovedCodec;

public class Codecs {
    public static void registerCodecs(CodecRegistry registry) {
        registry.register(
            (byte) EventIdentifier.Player.getGlobalId(),
            (byte) EventIdentifier.Player.PLAYER_MOVED.getId(),
            new PlayerMovedCodec()
        );
    }
}
