package br.com.pietroth.tsa.core.network.transport;

import java.io.IOException;

public interface Connection extends Runnable {
    byte[] read() throws IOException;
    void send(byte[] data) throws IOException;
}
