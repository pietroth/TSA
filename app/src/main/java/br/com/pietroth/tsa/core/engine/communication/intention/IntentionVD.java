package br.com.pietroth.tsa.core.engine.communication.intention;

import java.util.Map;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public class IntentionVD {
    private final Map<Short, IntentionValidator<? extends MIDFData>> validators;

    public IntentionVD(Map<Short, IntentionValidator<? extends MIDFData>> validators) {
        this.validators = validators;
    }

    public <T extends MIDFData> void registerValidator(byte family, byte type, IntentionValidator<T> validator) {
        short id = (short)((family << 8) | (type & 0xFF));
        validators.put(id, validator);
    }
    
    @SuppressWarnings("unchecked")
	public <T extends MIDFData> int validate(Intention<T> intention) {
        System.out.println("Looking validator for family=" + (intention.getFamily() & 0xFF)
            + " type=" + (intention.getType() & 0xFF));
            
        short id = (short)((intention.getFamily() << 8) | (intention.getType() & 0xFF));
        IntentionValidator<T> validator = (IntentionValidator<T>) validators.get(id);
        if (validator == null) {
            return -1;
        }
        return validator.validate(intention);
    }
}
