package br.com.pietroth.tsa.core.communication.event.player;

import br.com.pietroth.tsa.core.communication.event.Event;
import br.com.pietroth.tsa.core.communication.event.EventDispatcherSingleton;
import br.com.pietroth.tsa.core.communication.player.playermovement.PlayerMoveData;
import br.com.pietroth.tsa.core.communication.MIDFIdentifier;

public class PlayerEvents {

    public void publish_PlayerMoved(float sx, float sy) {
        PlayerMoveData data = new PlayerMoveData(sx, sy);
        Event<PlayerMoveData> event = new Event<PlayerMoveData>(
            MIDFIdentifier.Player.getGlobalId(),
            MIDFIdentifier.Player.PLAYER_MOVED.getId(),
            data
        );
        EventDispatcherSingleton.get().enqueue(event);
    }
}