package br.com.pietroth.tsa.core.engine.communication.response;

// IR means Immediate Response /ˈaɪər/ (air)

public class IR {
    private int correlationId; 
    private byte status;

    public IR(int status, int correlationId) {
        if (status < 0 || status > 255) {
            throw new IllegalArgumentException("Status must be between 0 and 255");
        }
        this.status = (byte) status;
        this.correlationId = correlationId;
    }

    public int getStatus() {
        return status & 0xFF;
    }

    public boolean isSuccess() {
        return status == 0;
    }

    public int getCorrelationId() {
        return correlationId;
    }
}