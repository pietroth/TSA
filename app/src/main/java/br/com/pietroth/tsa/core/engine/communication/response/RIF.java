package br.com.pietroth.tsa.core.engine.communication.response;

// RIF means Rejected or Intention Filter /ˈrɪf/ (riff)

public class RIF {
    private int correlationId; // Correlation ID with Intention and serves as a targetId
    private byte status;

    public RIF(int status, int correlationId) {
        if (status < 0 || status > 255) {
            throw new IllegalArgumentException("Status must be between 0 and 255");
        }
        this.status = (byte) status;
        this.correlationId = correlationId;
    }

    public int getStatus() {
        return status & 0xFF;
    }

    public int getCorrelationId() {
        return correlationId;
    }
}