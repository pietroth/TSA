package br.com.pietroth.tsa.core.event.player;

import br.com.pietroth.tsa.core.event.player.playermoved.PlayerMovedData;
import br.com.pietroth.tsa.core.event.Event;
import br.com.pietroth.tsa.core.event.EventDispatcher;
import br.com.pietroth.tsa.core.event.EventIdentifier;

public class PlayerEvents {
    private final EventDispatcher eventDispatcher;

    public PlayerEvents(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public void publish_PlayerMoved(float sx, float sy) {
        PlayerMovedData data = new PlayerMovedData(sx, sy);
        Event<PlayerMovedData> event = new Event<>(
            EventIdentifier.Player.getGlobalId(), EventIdentifier.Player.PLAYER_MOVED.getId(), data);
        eventDispatcher.enqueue(event);
    }
}
