package br.com.pietroth.tsa.core.engine.communication;

// MIDF literally means Message with Identifier, Data and Family. /ˈmiː.dɪ.fi/ (MEE-di-fi)

public abstract class MIDF<T extends MIDFData> {
    private final T data;

    public MIDF(T data) {
        this.data = data;
    }

    public byte getFamily() {
        return data.getFamily();
    }

    public byte getType() {
        return data.getType();
    }

    public T getData() {
        return data;
    }
}
