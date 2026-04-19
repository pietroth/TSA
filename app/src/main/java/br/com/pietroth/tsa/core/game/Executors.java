package br.com.pietroth.tsa.core.game;

import br.com.pietroth.tsa.core.engine.communication.event.EventDispatcherSingleton;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;
import br.com.pietroth.tsa.core.game.player.playermovement.PlayerMovedExecutor;

public class Executors {
    private final PlayerMovedExecutor playerMovedExecuter;

    public Executors(Builder builder) {
        this.playerMovedExecuter = builder.playerMovedExecuter;
    }

    public void registerExecuters() {
        EventDispatcherSingleton.get().register(
            (byte) MIDFGlossary.Player.getGlobalId(),
            (byte) MIDFGlossary.Player.PLAYER_MOVED.getId(),
            this.playerMovedExecuter
        );
    }

    public Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PlayerMovedExecutor playerMovedExecuter;
        
        public Builder playerMovedExecuter(PlayerMovedExecutor playerMovedExecuter) {
            this.playerMovedExecuter = playerMovedExecuter;
            return this;
        }

        public Executors build() {
            if (playerMovedExecuter == null) throw new IllegalStateException("PlayerMovedExecuter is required");
            return new Executors(this);
        }
    }
}
