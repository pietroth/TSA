package br.com.pietroth.tsa.core.communication.event;

import br.com.pietroth.tsa.core.communication.MIDFData;
import br.com.pietroth.tsa.core.communication.MIDF;

public class Event<T extends MIDFData> extends MIDF<T> {
    
    public Event(byte family, byte type, T data) {
        super(family, type, data);
    }
}
