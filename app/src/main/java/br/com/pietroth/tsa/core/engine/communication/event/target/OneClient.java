package br.com.pietroth.tsa.core.engine.communication.event.target;

public class OneClient implements TargetModifier {
    public final int clientId;

    public OneClient(int clientId){
        this.clientId = clientId;
    }
}
