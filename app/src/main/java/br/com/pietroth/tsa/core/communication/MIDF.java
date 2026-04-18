package br.com.pietroth.tsa.core.communication;

// MIDF literally means MIDF with Identifier, Data and Family. /ˈmiː.dɪ.fi/ (MEE-di-fi)

public abstract class MIDF<T extends MIDFData> {
    private final byte family;
    private final byte type;
    private final T data;

    public MIDF(byte family, byte type, T data) {
        this.family = family;
        this.type = type;
        this.data = data;
    }

    public byte getFamily() {
        return family;
    }

    public byte getType() {
        return type;
    }

    public T getData() {
        return data;
    }
}
