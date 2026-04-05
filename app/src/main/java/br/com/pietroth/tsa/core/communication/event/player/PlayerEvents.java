package br.com.pietroth.tsa.core.communication.event.player;

import br.com.pietroth.tsa.core.communication.event.Event;
import br.com.pietroth.tsa.core.communication.event.EventDispatcher;
import br.com.pietroth.tsa.core.communication.player.playermovement.PlayerMoveData;
import br.com.pietroth.tsa.core.communication.MessageIdentifier;

public class PlayerEvents {
    private final EventDispatcher eventDispatcher;

    public PlayerEvents(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public void publish_PlayerMoved(float sx, float sy) {
        PlayerMoveData data = new PlayerMoveData(sx, sy);
        Event<PlayerMoveData> event = new Event<PlayerMoveData>(
            MessageIdentifier.Player.getGlobalId(),
            MessageIdentifier.Player.PLAYER_MOVED.getId(),
            data
        );
        eventDispatcher.enqueue(event);
    }
}