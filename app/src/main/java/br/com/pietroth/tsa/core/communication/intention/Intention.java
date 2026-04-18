package br.com.pietroth.tsa.core.communication.intention;

import br.com.pietroth.tsa.core.communication.MIDF;
import br.com.pietroth.tsa.core.communication.MIDFData;

public class Intention<T extends MIDFData> extends MIDF<T> {
    private int correlationId; // Correlation ID with Response

    public Intention(byte family, byte type, T data, int correlationId) {
        super(family, type, data);
    }

    public int getCorrelationId() {
        return correlationId;
    }
}
