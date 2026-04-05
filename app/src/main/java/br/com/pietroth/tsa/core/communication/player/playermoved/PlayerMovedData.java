package br.com.pietroth.tsa.core.communication.player.playermoved;

import br.com.pietroth.tsa.core.communication.MessageData;

public class PlayerMovedData implements MessageData {
    public final float sx;
    public final float sy;

    public PlayerMovedData(float sx, float sy) {
        this.sx = sx;
        this.sy = sy;
    }
}
