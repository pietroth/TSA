package br.com.pietroth.tsa.core.engine.network;

import java.io.OutputStream;
import java.util.Arrays;

public class NetworkAggregator {
    private final byte[][] buffers;
    private final int[] cursors;

    public NetworkAggregator(int maxBuffers, int initialBufferSize) {
        this.buffers = new byte[maxBuffers][initialBufferSize];
        this.cursors = new int[maxBuffers];
    }

    public synchronized void append(int bufferId, byte[] data) {
        int pos = cursors[bufferId];
        if (pos + data.length > buffers[bufferId].length) {
            // expand buffer if needed
            buffers[bufferId] = Arrays.copyOf(buffers[bufferId], buffers[bufferId].length * 2);
        }

        System.arraycopy(data, 0, buffers[bufferId], pos, data.length);
        cursors[bufferId] += data.length;
    }

    private void clear(int bufferId) {
        cursors[bufferId] = 0;
    }

    public synchronized void flush(int bufferId, OutputStream outputStream) {
        int bytesToSend = cursors[bufferId];
        if (bytesToSend > 0) {
            try {
                outputStream.write(buffers[bufferId], 0, bytesToSend);
                outputStream.flush();
                clear(bufferId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void flushAll(OutputStream[] outputStreams) {
        int limit = Math.min(buffers.length, outputStreams.length);
        for (int i = 0; i < limit; i++) {
                if (outputStreams[i] != null) { 
            flush(i, outputStreams[i]);
            }
        }
    }
}
