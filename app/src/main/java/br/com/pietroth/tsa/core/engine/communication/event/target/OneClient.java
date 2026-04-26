package br.com.pietroth.tsa.core.engine.communication.event.target;

import java.util.ArrayList;

public class OneClient implements TargetModifier {
    public final int clientId;

    public OneClient(Integer clientId){
        this.clientId = clientId;
    }

    @Override
    public ArrayList<Integer> toList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(clientId);
        return list;
    }

    @Override
    public int[] toArrayList() {
        return new int[] { clientId };
    }
}
