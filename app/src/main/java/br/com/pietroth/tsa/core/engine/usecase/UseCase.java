package br.com.pietroth.tsa.core.engine.usecase;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.intention.Intention;

public interface UseCase<T extends MIDFData> {
    void execute(Intention<T> intention);
}
