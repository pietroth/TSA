package br.com.pietroth.tsa.core.game.player;

import br.com.pietroth.tsa.core.engine.communication.event.Event;
import br.com.pietroth.tsa.core.engine.communication.event.EventPublisherSingleton;
import br.com.pietroth.tsa.core.engine.communication.event.target.OneClient;
import br.com.pietroth.tsa.core.engine.communication.event.target.TargetScope;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveData;

public class PlayerEvents {

    public static void publish_PlayerMoved(int originId, int playerId, float sx, float sy) {
        PlayerMoveData data = new PlayerMoveData(playerId, sx, sy);
        Event<PlayerMoveData> event = new Event<PlayerMoveData>(
            MIDFGlossary.Player.getGlobalId(),
            MIDFGlossary.Player.PLAYER_MOVED.getId(),
            data,
            1,
            new TargetScope(new OneClient(playerId))
        );
        EventPublisherSingleton.get().publish(event);
    }
}