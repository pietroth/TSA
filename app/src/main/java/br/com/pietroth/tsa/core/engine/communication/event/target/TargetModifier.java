package br.com.pietroth.tsa.core.engine.communication.event.target;

import java.util.List;

public interface TargetModifier {
    List<Integer> toList();
    int[] toArrayList();
}
