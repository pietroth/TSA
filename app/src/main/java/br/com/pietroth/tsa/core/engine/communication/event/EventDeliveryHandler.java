package br.com.pietroth.tsa.core.engine.communication.event;

import java.lang.foreign.MemorySegment;

import br.com.pietroth.tsa.core.engine.communication.event.target.TargetModifier;
import br.com.pietroth.tsa.core.engine.communication.event.target.TargetScope;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManager;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManagerSingleton;

public class EventDeliveryHandler {
    private final ClientLCManager clientLCManager;

    public EventDeliveryHandler() {
        this.clientLCManager = ClientLCManagerSingleton.get();
    }

    public void delivery(MemorySegment segment, int removedId, TargetScope target) {
        if (target.forAllClients) {
            clientLCManager.sendToAll(segment);
            return;
        }

        TargetModifier modifier = target.modifier;
        clientLCManager.sendTo(modifier.exclude(removedId).toArray(), segment);
    }
}
