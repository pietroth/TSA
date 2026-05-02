package br.com.pietroth.tsa.core.engine.communication.intention;

import br.com.pietroth.tsa.core.engine.communication.MIDF;
import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public class Intention<T extends MIDFData> extends MIDF<T> {
    private final int originId;
    private final int correlationId; // Correlation ID with Response

    public Intention(T data, int correlationId, int originId) {
        super(data);
        this.correlationId = correlationId;
        this.originId = originId;
    }

    public int getCorrelationId() {
        return correlationId;
    }

    public int getOriginId() {
        return originId;
    }
}
