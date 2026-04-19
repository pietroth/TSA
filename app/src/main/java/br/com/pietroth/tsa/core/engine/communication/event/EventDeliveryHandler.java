package br.com.pietroth.tsa.core.engine.communication.event;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.MIDFEncoder;
import br.com.pietroth.tsa.core.engine.communication.event.target.TargetModifier;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManager;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManagerSingleton;

public class EventDeliveryHandler {
    private final MIDFEncoder encoder;

    public EventDeliveryHandler(MIDFEncoder encoder) {
        this.encoder = encoder;
    }

    public void delivery(Event<? extends MIDFData> event) {
        ClientLCManager clientLCManager = ClientLCManagerSingleton.get();
        byte[] raw = encoder.encode(event);

        if (event.getTarget().forAllClients) {
            clientLCManager.sendToAll(raw);
            return;
        }

        TargetModifier modifier = event.getTarget().modifier;
        List<Integer> ids = modifier.toList().stream()
            .map(AtomicInteger::get)
            .toList();

        clientLCManager.sendTo(ids, raw);
    }
}
