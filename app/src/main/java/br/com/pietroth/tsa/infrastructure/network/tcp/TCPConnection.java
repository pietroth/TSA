package br.com.pietroth.tsa.infrastructure.network.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.io.DataInputStream;
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

    private void notifyConnectionReceived(Connection connection, byte[] data) {
        for (ConnectionReceivedListener listener : listeners) {
            listener.onConnectionReceived(connection, data);
        }
    }

    @Override 
    public void run() {
        while (true) {
            try {
                byte[] data = read();

                // debug log
                if (data != null && data.length > 0) {
                     System.out.println("Received data from client: " + data.length + " bytes");
                }
                    
                if (listeners != null) {
                    notifyConnectionReceived(this, data);
                }

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
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

        if (length < 6) {
            throw new IOException("Invalid frame size: " + length);
        }

        byte[] raw = new byte[length];
        ByteBuffer.wrap(raw).putInt(length);

        dis.readFully(raw, 4, length -4);    

        return raw;
    }

    @Override
    public void send(byte[] data) throws IOException {
        output.write(data);
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
}