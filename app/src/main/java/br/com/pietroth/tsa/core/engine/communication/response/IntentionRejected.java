package br.com.pietroth.tsa.core.engine.communication.response;

public class IntentionRejected {
    private int correlationId; // Correlation ID with Intention and serves as a targetId
    private byte status;

    public IntentionRejected(int status, int correlationId) {
        if (status < 0 || status > 255) {
            throw new IllegalArgumentException("Status must be between 0 and 255");
        }
        this.status = (byte) status;
    }

    public int getStatus() {
        return status & 0xFF;
    }

    public int getCorrelationId() {
        return correlationId;
    }
}