package br.com.pietroth.tsa.core.engine.communication.event;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.event.target.TargetScope;
import br.com.pietroth.tsa.core.engine.communication.MIDF;

public class Event<T extends MIDFData> extends MIDF<T> {
    private final int originId;
    private final TargetScope target;

    public Event(T data, int originId, TargetScope target) {
        super(data);
        this.originId = originId;
        this.target = target;
    }

    public int getOriginId() {
        return originId;
    }

    public TargetScope getTarget() {
        return target;
    }

    
}
