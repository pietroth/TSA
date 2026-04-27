package br.com.pietroth.tsa.core.engine.communication.event;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.MIDFEncoder;
import br.com.pietroth.tsa.core.engine.communication.event.target.TargetModifier;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManager;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManagerSingleton;

public class EventDeliveryHandler {
    private final MIDFEncoder encoder;
    private final ClientLCManager clientLCManager;

    public EventDeliveryHandler(MIDFEncoder encoder) {
        this.encoder = encoder;
        this.clientLCManager = ClientLCManagerSingleton.get();
    }

    public void delivery(Event<? extends MIDFData> event) {
        try (Arena deliveryArena = Arena.ofConfined()) {
            MemorySegment segment = encoder.encode(deliveryArena, event);
            
            if (event.getTarget().forAllClients) {
                clientLCManager.sendToAll(segment);
                return;
            }

            TargetModifier modifier = event.getTarget().modifier;
            int[] ids = modifier.toArrayList();

            clientLCManager.sendTo(ids, segment);
        }
    }

}
