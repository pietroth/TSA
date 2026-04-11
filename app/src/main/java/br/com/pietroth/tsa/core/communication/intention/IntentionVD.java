package br.com.pietroth.tsa.core.communication.intention;

import java.util.Map;

import br.com.pietroth.tsa.core.communication.MessageData;

public class IntentionVD {
    private final Map<Short, IntentionValidator<? extends MessageData>> validators;

    public IntentionVD(Map<Short, IntentionValidator<? extends MessageData>> validators) {
        this.validators = validators;
    }

    public <T extends MessageData> void registerValidator(byte family, byte type, IntentionValidator<T> validator) {
        short id = (short)((family << 8) | (type & 0xFF));
        validators.put(id, validator);
    }
    
    @SuppressWarnings("unchecked")
	public <T extends MessageData> int validate(Intention<T> intention) {
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
