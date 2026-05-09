package br.com.pietroth.tsa.core.engine.communication.response;

import java.lang.foreign.MemorySegment;

// IR means Immediate Response /ˈaɪər/ (air)

public final class IR {
    public static final int SUCCESS = 0;
    public static final int PARTIAL = 1;
    public static final int ERROR = 2; 

    private final int correlationId; 
    private final byte status;
    private final byte errorCode;
    private final MemorySegment data;

    public IR(Builder builder) {
        this.correlationId = builder.correlationId;
        this.status = builder.status;
        this.errorCode = builder.errorCode;
        this.data = builder.data;
    } 

    public byte getStatus() {
        return status;
    }

    public boolean isSuccess() {
        return status == 0;
    }

    public int getCorrelationId() {
        return correlationId;
    }

    public byte getErrorCode() {
        return errorCode;
    }

    public MemorySegment getData() {
        return data;
    }

    public static class Builder {
        private int correlationId;
        private byte status = -1;
        private byte errorCode;
        private MemorySegment data;
        private boolean modeSet = false; 

        // Assistant method to verify if one of the methos alredy be called;
        private void checkModeSet() {
            if (modeSet) {
                throw new IllegalStateException("Um dos métodos (success, partial, error) já foi chamado!");
            }
        }

        public Builder success(int correlationId, byte status) {
            checkModeSet();
            this.correlationId = correlationId;
            this.status = status;
            this.modeSet = true;
            return this;
        }

        public Builder partial(int correlationId, byte status, MemorySegment data) {
            checkModeSet();
            this.correlationId = correlationId;
            this.status = status;
            this.data = data;
            this.modeSet = true;
            return this;
        }

        public Builder error(int correlationId, byte status, byte errorCode) {
            checkModeSet();
            this.correlationId = correlationId;
            this.status = status;
            this.errorCode = errorCode;
            this.modeSet = true;
            return this;
        }

        public IR build() {
            if (!modeSet) {
                throw new IllegalStateException("None method has been called!");
            }
            if (status < 0 || status > 2) {
                throw new IllegalStateException("Status must be between 0 and 2!");
            }
    
            return new IR(this);
        }
    }
}