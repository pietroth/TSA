package br.com.pietroth.tsa.core.engine.communication.event.target;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OneClient implements TargetModifier {

    public final int clientId;
    private final List<Integer> cachedList;

    public OneClient(Integer clientId) {
        this.clientId = clientId;
        
        ArrayList<Integer> list = new ArrayList<>(1);  // capacity hint avoids resize
        list.add(clientId);
        this.cachedList = Collections.unmodifiableList(list);
    }

    @Override
    public List<Integer> toList() {
        return cachedList;  // same instance every time, zero allocation
    }

    @Override
    public int[] toArrayList() {
        return new int[] { clientId };
    }
}