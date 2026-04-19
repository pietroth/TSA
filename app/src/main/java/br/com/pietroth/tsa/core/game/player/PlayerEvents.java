package br.com.pietroth.tsa.core.game.player;

import br.com.pietroth.tsa.core.engine.communication.event.Event;
import br.com.pietroth.tsa.core.engine.communication.event.EventDispatcherSingleton;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMoveData;

public class PlayerEvents {

    public void publish_PlayerMoved(float sx, float sy) {
        PlayerMoveData data = new PlayerMoveData(sx, sy);
        Event<PlayerMoveData> event = new Event<PlayerMoveData>(
            MIDFGlossary.Player.getGlobalId(),
            MIDFGlossary.Player.PLAYER_MOVED.getId(),
            data,
            1,
            null
        );
        EventDispatcherSingleton.get().enqueue(event);
    }
}