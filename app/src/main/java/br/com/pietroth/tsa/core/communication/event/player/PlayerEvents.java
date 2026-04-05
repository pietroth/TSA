package br.com.pietroth.tsa.core.communication.event.player;

import br.com.pietroth.tsa.core.communication.event.Event;
import br.com.pietroth.tsa.core.communication.event.EventDispatcher;
import br.com.pietroth.tsa.core.communication.MessageIdentifier;
import br.com.pietroth.tsa.core.communication.player.playermoved.PlayerMovementData;

public class PlayerEvents {
    private final EventDispatcher eventDispatcher;

    public PlayerEvents(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public void publish_PlayerMoved(float sx, float sy) {
        PlayerMovementData data = new PlayerMovementData(sx, sy);
        Event<PlayerMovementData> event = new Event<PlayerMovementData>(
            MessageIdentifier.Player.getGlobalId(),
            MessageIdentifier.Player.PLAYER_MOVED.getId(),
            data
        );
        eventDispatcher.enqueue(event);
    }
}