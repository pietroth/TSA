package br.com.pietroth.tsa.core.communication.event.codec;

import br.com.pietroth.tsa.core.communication.MessageIdentifier;
import br.com.pietroth.tsa.core.communication.player.playermoved.PlayerMovedCodec;

public class Codecs {
    public static void registerCodecs(CodecRegistry registry) {
        registry.register(
            (byte) MessageIdentifier.Player.getGlobalId(),
            (byte) MessageIdentifier.Player.PLAYER_MOVED.getId(),
            new PlayerMovedCodec()
        );
    }
}
