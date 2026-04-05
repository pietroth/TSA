package br.com.pietroth.tsa.core.communication.event;

import br.com.pietroth.tsa.core.communication.MessageData;
import br.com.pietroth.tsa.core.communication.Message;

public class Event<T extends MessageData> extends Message<T> {
    
    public Event(byte family, byte type, T data) {
        super(family, type, data);
    }
}
