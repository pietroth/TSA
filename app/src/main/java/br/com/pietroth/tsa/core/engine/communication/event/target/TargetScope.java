package br.com.pietroth.tsa.core.engine.communication.event.target;

public class TargetScope {
    public final boolean forAllClients;
    public TargetModifier modifier;

    public TargetScope(boolean forAllClients) {
        this.forAllClients = forAllClients;
        this.modifier = null;
    }

    public TargetScope(TargetModifier modifier) {
        this.forAllClients = false;
        this.modifier = modifier;
    }

    public TargetScope exclude(int id) {
        if (this.modifier != null) {
            this.modifier = this.modifier.exclude(id);
        }   
        return this;
    }
}
