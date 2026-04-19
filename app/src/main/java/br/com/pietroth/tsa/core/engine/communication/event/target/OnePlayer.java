package br.com.pietroth.tsa.core.engine.communication.event.target;

public class OnePlayer implements TargetModifier {
    public final int clientId;

    public OnePlayer(int clientId){
        this.clientId = clientId;
    }
}
