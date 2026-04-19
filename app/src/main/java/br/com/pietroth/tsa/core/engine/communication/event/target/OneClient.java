package br.com.pietroth.tsa.core.engine.communication.event.target;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class OneClient implements TargetModifier {
    public final AtomicInteger clientId;

    public OneClient(AtomicInteger clientId){
        this.clientId = clientId;
    }

    @Override
    public ArrayList<AtomicInteger> toList() {
        ArrayList<AtomicInteger> list = new ArrayList<>();
        list.add(clientId);
        return list;
    }
}
