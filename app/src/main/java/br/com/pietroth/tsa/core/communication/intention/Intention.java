package br.com.pietroth.tsa.core.communication.intention;

import br.com.pietroth.tsa.core.communication.Message;
import br.com.pietroth.tsa.core.communication.MessageData;

public class Intention<T extends MessageData> extends Message<T> {

    public Intention(byte family, byte type, T data) {
        super(family, type, data);
    }
}
