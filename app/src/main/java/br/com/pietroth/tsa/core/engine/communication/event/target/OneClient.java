package br.com.pietroth.tsa.core.engine.communication.event.target;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.pietroth.tsa.core.engine.network.client.ClientId;

public class OneClient implements TargetModifier {
    public final AtomicInteger clientId;

    public OneClient(AtomicInteger clientId){
        this.clientId = clientId;
    }

    @Override
    public ArrayList<ClientId> toList() {
        ArrayList<ClientId> list = new ArrayList<>();
        list.add(new ClientId(clientId));
        return list;
    }
}
