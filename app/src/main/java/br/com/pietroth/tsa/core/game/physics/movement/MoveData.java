package br.com.pietroth.tsa.core.game.physics.movement;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;

public class MoveData implements MIDFData {
    private final byte type;
    private final byte family;

    public final float sx;
    public final float sy;

    public MoveData(float sx, float sy) {
        this.sx = sx;
        this.sy = sy;
        this.type = MIDFGlossary.Physics.ENTITY_MOVE.getId();
        this.family = MIDFGlossary.Physics.getGlobalId();
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
