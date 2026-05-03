package br.com.pietroth.tsa.infrastructure.network.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.net.Socket;
import java.io.EOFException;
import java.util.List;

import br.com.pietroth.tsa.core.engine.network.transport.Connection;
import br.com.pietroth.tsa.core.engine.network.transport.ConnectionReceivedListener;

import java.util.ArrayList;

public class TCPConnection implements Connection {
    private int id;
    private final InputStream input;
    private final OutputStream output;
    private List<ConnectionReceivedListener> listeners = new ArrayList<>();

    public TCPConnection(Socket socket, int id) throws IOException 
    {
        this.id = id;
        this.input = socket.getInputStream();
        this.output = socket.getOutputStream();
    }

    public TCPConnection(Socket socket) throws IOException 
    {
        this.id = 0;
        this.input = socket.getInputStream();
        this.output = socket.getOutputStream();
    }

    @Override
    public void subscribe(ConnectionReceivedListener listener) {
        listeners.add(listener);
    }

    @Override
    public void unsubscribe(ConnectionReceivedListener listener) {
        listeners.remove(listener);
    }

    private void notifyConnectionReceived(Connection connection, MemorySegment segment) {
        for (ConnectionReceivedListener listener : listeners) {
            listener.onConnectionReceived(connection, segment);
        }
    }

    @Override 
    public void run() {
        try (Arena arena = Arena.ofConfined()) {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    MemorySegment segment = read(arena);

                    if (segment != null) {
                        notifyConnectionReceived(this, segment);
                    }
                } catch (IOException e) {
                    break;
                }
            }
        }
    }

    @Override
    public MemorySegment read(Arena arena) throws IOException {
        byte[] header = new byte[4];
        readFully(input, header, 4);
        int length = (header[0] & 0xFF) |
            ((header[1] & 0xFF) << 8) |
            ((header[2] & 0xFF) << 16) |
            ((header[3] & 0xFF) << 24);
        if (length < 6) throw new IOException("Invalid frame size");

        MemorySegment segment = arena.allocate(length);

        segment.set(ValueLayout.JAVA_INT, 0, length);

        byte[] buffer = new byte[length - 4];
        readFully(input, buffer, length - 4);

        segment.asSlice(4).copyFrom(MemorySegment.ofArray(buffer));

        return segment;
    }

    @Override
    public void send(MemorySegment segment) throws IOException {
        output.write(segment.toArray(ValueLayout.JAVA_BYTE));
        output.flush();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    private void readFully(InputStream in, byte[] b, int len) throws IOException {
        int n = 0;
        while (n < len) {
            int count = in.read(b, n, len - n);
            if (count < 0) throw new EOFException();
            n += count;
        }
    }

    @Override
    public OutputStream getOutputStream() {
        return output;
    }
}
