package br.com.pietroth.tsa.core.communication.player.playermovement;

import br.com.pietroth.tsa.core.communication.MessageData;

public class PlayerMoveData implements MessageData {
    public final float sx;
    public final float sy;

    public PlayerMoveData(float sx, float sy) {
        this.sx = sx;
        this.sy = sy;
    }
}
