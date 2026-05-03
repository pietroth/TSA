package br.com.pietroth.tsa.core.engine.network.transport;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public interface Connection extends Runnable {
    MemorySegment read(Arena arena) throws IOException;
    void send(MemorySegment segment) throws IOException;
    void subscribe(ConnectionReceivedListener listener);
    void unsubscribe(ConnectionReceivedListener listener);
    void setId(int id);
    int getId();
    OutputStream getOutputStream();
}
