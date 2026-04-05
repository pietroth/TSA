package br.com.pietroth.tsa.core.communication.event;

import br.com.pietroth.tsa.core.communication.MessageIdentifier;
import br.com.pietroth.tsa.core.communication.event.player.playermoved.PlayerMovedExecuter;

public class Executers {
    private final PlayerMovedExecuter playerMovedExecuter;

    public Executers(Builder builder) {
        this.playerMovedExecuter = builder.playerMovedExecuter;
    }

    public void registerExecuters(EventDispatcher dispatcher) {
        dispatcher.register(
            (byte) MessageIdentifier.Player.getGlobalId(),
            (byte) MessageIdentifier.Player.PLAYER_MOVED.getId(),
            this.playerMovedExecuter
        );
    }

    public Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PlayerMovedExecuter playerMovedExecuter;

        public Builder playerMovedExecuter(PlayerMovedExecuter playerMovedExecuter) {
            this.playerMovedExecuter = playerMovedExecuter;
            return this;
        }

        public Executers build() {
            if (playerMovedExecuter == null) throw new IllegalStateException("PlayerMovedExecuter is required");
            return new Executers(this);
        }
    }
}
