package br.com.pietroth.tsa.core.communication.event.player;

import br.com.pietroth.tsa.core.communication.event.Event;
import br.com.pietroth.tsa.core.communication.event.EventDispatcherSingleton;
import br.com.pietroth.tsa.core.communication.player.playermovement.PlayerMoveData;
import br.com.pietroth.tsa.core.communication.MIDFGlossary;

public class PlayerEvents {

    public void publish_PlayerMoved(float sx, float sy) {
        PlayerMoveData data = new PlayerMoveData(sx, sy);
        Event<PlayerMoveData> event = new Event<PlayerMoveData>(
            MIDFGlossary.Player.getGlobalId(),
            MIDFGlossary.Player.PLAYER_MOVED.getId(),
            data
        );
        EventDispatcherSingleton.get().enqueue(event);
    }
}