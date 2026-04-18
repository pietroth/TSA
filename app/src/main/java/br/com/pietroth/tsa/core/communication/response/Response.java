package br.com.pietroth.tsa.core.communication.response;

public class Response {
    private int correlationId;
    private byte status;

    public Response(int status, int correlationId) {
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