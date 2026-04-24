package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public class PlayerMoveData implements MIDFData {
    public final int playerId;
    public final float sx;
    public final float sy;

    public PlayerMoveData(int playerId, float sx, float sy) {
        this.playerId = playerId;
        this.sx = sx;
        this.sy = sy;
    }
}
