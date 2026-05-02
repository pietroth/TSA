package br.com.pietroth.tsa.core.game.player.playermovement;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;

public class PlayerMoveData implements MIDFData {
    private final byte type;
    private final byte family;

    public final int playerId;
    public final float sx;
    public final float sy;

    public PlayerMoveData(int playerId, float sx, float sy) {
        this.type = MIDFGlossary.Player.PLAYER_MOVE.getId();
        this.family = MIDFGlossary.Player.getGlobalId();
        this.playerId = playerId;
        this.sx = sx;
        this.sy = sy;
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
