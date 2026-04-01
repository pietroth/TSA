package br.com.pietroth.tsa.core.network.transport;

import java.io.IOException;

import br.com.pietroth.tsa.core.event.Event;
import br.com.pietroth.tsa.core.event.EventData;

public interface Connection {
    byte[] read() throws IOException;
    void send(Event<? extends EventData> event) throws IOException;
}
