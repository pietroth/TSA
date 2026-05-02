package br.com.pietroth.tsa.core.game.physics.movement;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public class MoveData implements MIDFData {
    private final byte type;
    private final byte family;

    public final float sx;
    public final float sy;

    public MoveData(byte family, byte type, float sx, float sy) {
        this.sx = sy;
        this.sy = sy;
        this.type = type;
        this.family = family;
    }

    @Override
    public byte getType() {
        return type;
    }

    @Override
    public byte getFamily() {
        return family;
    }
}
