package br.com.pietroth.tsa.core.engine.usecase;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public interface UseCase<T extends MIDFData> {
    void execute(T data);
}
