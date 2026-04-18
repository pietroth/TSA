package br.com.pietroth.tsa.core.communication.intention;

import br.com.pietroth.tsa.core.communication.MIDF;
import br.com.pietroth.tsa.core.communication.MIDFData;

public class Intention<T extends MIDFData> extends MIDF<T> {

    public Intention(byte family, byte type, T data) {
        super(family, type, data);
    }
}
