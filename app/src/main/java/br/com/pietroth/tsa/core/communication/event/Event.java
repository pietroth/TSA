package br.com.pietroth.tsa.core.communication.event;

import br.com.pietroth.tsa.core.communication.MIDFData;
import br.com.pietroth.tsa.core.communication.MIDF;

public class Event<T extends MIDFData> extends MIDF<T> {
    private final int originId;
    private final int targetId;

    public Event(byte family, byte type, T data, int originId, int targetId) {
        super(family, type, data);
        this.originId = originId;
        this.targetId = targetId;
    }

    public int getOriginId() {
        return originId;
    }

    public int getTargetId() {
        return targetId;
    }
}
