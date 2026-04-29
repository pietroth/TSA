package br.com.pietroth.tsa.core.engine.communication.event.target;

public class OneClient implements TargetModifier {

    public final int clientId;

    public OneClient(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public int[] toArray() {
        return new int[] { clientId };
    }

    @Override
    public TargetModifier exclude(int id) {
        if (clientId == id) {
            return (TargetModifier) () -> new int[0];
        }
        return this;
    }
}