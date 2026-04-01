package br.com.pietroth.tsa.core.network.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

import br.com.pietroth.tsa.core.event.EventEncoder;
import br.com.pietroth.tsa.core.event.Event;
import br.com.pietroth.tsa.core.event.EventData;
import br.com.pietroth.tsa.core.event.codec.Codec;
import br.com.pietroth.tsa.core.event.codec.CodecRegistry;

public class TCPClientConnection implements Connection {
    private final InputStream input;
    private final OutputStream output;
    private final EventEncoder encoder;

    public TCPClientConnection(
        Socket socket, EventEncoder encoder) throws IOException 
    {
        this.input = socket.getInputStream();
        this.output = socket.getOutputStream();
        this.encoder = encoder;
    }

    @Override
    public byte[] read() throws IOException {

        byte[] buffer = new byte[1024];
        int bytesRead = input.read(buffer);

        if (bytesRead == -1) {
            throw new IOException("Disconnected");
        }

        return Arrays.copyOf(buffer, bytesRead);
    }

    @Override
    public void send(Event<? extends EventData> event) throws IOException {
        byte[] data = encoder.encode(event);
        output.write(data);
        output.flush();
    }
}