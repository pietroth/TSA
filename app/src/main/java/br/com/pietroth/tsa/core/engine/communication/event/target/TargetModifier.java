package br.com.pietroth.tsa.core.engine.communication.event.target;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface TargetModifier {
    List<AtomicInteger> toList();
}
