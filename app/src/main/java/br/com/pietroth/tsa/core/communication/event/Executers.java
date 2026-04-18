package br.com.pietroth.tsa.core.communication.event;

import br.com.pietroth.tsa.core.communication.MIDFIdentifier;
import br.com.pietroth.tsa.core.communication.event.player.playermoved.PlayerMovedExecuter;

public class Executers {
    private final PlayerMovedExecuter playerMovedExecuter;

    public Executers(Builder builder) {
        this.playerMovedExecuter = builder.playerMovedExecuter;
    }

    public void registerExecuters() {
        EventDispatcherSingleton.get().register(
            (byte) MIDFIdentifier.Player.getGlobalId(),
            (byte) MIDFIdentifier.Player.PLAYER_MOVED.getId(),
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
