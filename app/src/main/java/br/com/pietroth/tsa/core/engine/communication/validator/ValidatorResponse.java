package br.com.pietroth.tsa.core.engine.communication.validator;

import java.lang.foreign.MemorySegment;

public class ValidatorResponse {
    private final ValidatorType type;
    private final byte code;
    private final MemorySegment data;

    private ValidatorResponse(ValidatorType type, byte code, MemorySegment data) {
        this.type = type;
        this.code = code;
        this.data = data;
    }

    public static ValidatorResponse success() {
        return new ValidatorResponse(ValidatorType.SUCCESS, (byte) 0, MemorySegment.NULL);
    }

    public static ValidatorResponse error(byte code) {
        return new ValidatorResponse(ValidatorType.ERROR, code, MemorySegment.NULL);
    }

    public static ValidatorResponse partial(byte code, MemorySegment segment) {
        return new ValidatorResponse(ValidatorType.PARTIAL, code, segment);
    }

    public ValidatorType getType() {
        return type;
    }

    public byte getCode() {
        return code;
    }

    public MemorySegment getData() {
        return data;
    }
}
