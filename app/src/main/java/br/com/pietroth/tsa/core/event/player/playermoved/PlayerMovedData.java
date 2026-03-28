package br.com.pietroth.tsa.core.event.player.playermoved;

import br.com.pietroth.tsa.core.event.EventData;

public class PlayerMovedData implements EventData {
    public final float sx;
    public final float sy;

    public PlayerMovedData(float sx, float sy) {
        this.sx = sx;
        this.sy = sy;
    }
}
