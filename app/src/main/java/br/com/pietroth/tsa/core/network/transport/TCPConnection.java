package br.com.pietroth.tsa.core.network.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.EOFException;
import java.util.List;
import java.util.ArrayList;

public class TCPConnection implements Connection {
    private final InputStream input;
    private final OutputStream output;
    private final List<ConnectionReceivedListener> listeners = new ArrayList<>();

    public TCPConnection(Socket socket) throws IOException 
    {
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

        byte[] raw = new byte[length];
        dis.readFully(raw);    

        return raw;
    }

    @Override
    public void send(byte[] data) throws IOException {
        output.write(data);
        output.flush();
    }
}