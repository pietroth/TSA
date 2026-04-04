package br.com.pietroth.tsa.core.network.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import java.io.DataInputStream;
import java.io.EOFException;

import br.com.pietroth.tsa.core.event.EventEncoder;
import br.com.pietroth.tsa.core.event.Event;
import br.com.pietroth.tsa.core.event.EventData;

public class TCPConnection implements Connection {
    private final InputStream input;
    private final OutputStream output;
    private final EventEncoder encoder;

    public TCPConnection(
        Socket socket, EventEncoder encoder) throws IOException 
    {
        this.input = socket.getInputStream();
        this.output = socket.getOutputStream();
        this.encoder = encoder;
    }

    @Override 
    public void run() {
        // No-op, reading is handled by ClientHandler
    }

    @Override
    public byte[] read() throws IOException {
        DataInputStream dis = new DataInputStream(input);

        int length;
        try {
            length = dis.readInt();

        } catch (EOFException e) {
            throw new IOException("Disconnected", e);
        }

        byte[] raw = new byte[length];
        dis.readFully(raw);    

        return raw;
    }

    @Override
    public void send(Event<? extends EventData> event) throws IOException {
        byte[] data = encoder.encode(event);
        output.write(data);
        output.flush();
    }
}