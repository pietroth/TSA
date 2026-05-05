package br.com.pietroth.tsa.core.engine.communication.validator;

public enum ValidatorType {
    SUCCESS(0),
    ERROR(1),
    PARTIAL(2);
    
    private final int id;      

    ValidatorType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
