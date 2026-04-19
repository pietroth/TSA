package br.com.pietroth.tsa.core.engine.communication.player.playermovement;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public class PlayerMoveData implements MIDFData {
    public final float sx;
    public final float sy;

    public PlayerMoveData(float sx, float sy) {
        this.sx = sx;
        this.sy = sy;
    }
}
