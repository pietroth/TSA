package br.com.pietroth.tsa.core.engine.usecase;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

@FunctionalInterface
public interface UseCase<T extends MIDFData> {
    void execute(int entityId, T data);
}
