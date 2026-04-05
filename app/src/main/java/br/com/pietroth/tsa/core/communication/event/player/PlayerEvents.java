package br.com.pietroth.tsa.core.communication.event.player;

import br.com.pietroth.tsa.core.communication.event.Event;
import br.com.pietroth.tsa.core.communication.event.EventDispatcher;
import br.com.pietroth.tsa.core.communication.MessageIdentifier;
import br.com.pietroth.tsa.core.communication.player.playermoved.PlayerMovedData;

public class PlayerEvents {
    private final EventDispatcher eventDispatcher;

    public PlayerEvents(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public void publish_PlayerMoved(float sx, float sy) {
        PlayerMovedData data = new PlayerMovedData(sx, sy);
        Event<PlayerMovedData> event = new Event<PlayerMovedData>(
            MessageIdentifier.Player.getGlobalId(),
            MessageIdentifier.Player.PLAYER_MOVED.getId(),
            data
        );
        eventDispatcher.enqueue(event);
    }
}