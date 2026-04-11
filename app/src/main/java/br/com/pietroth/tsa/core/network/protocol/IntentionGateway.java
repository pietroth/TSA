package br.com.pietroth.tsa.core.network.protocol;

import br.com.pietroth.tsa.core.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.communication.intention.IntentionVD;
import br.com.pietroth.tsa.core.network.transport.Connection;
import br.com.pietroth.tsa.core.network.transport.ConnectionReceivedListener;
import br.com.pietroth.tsa.core.communication.intention.IntentionVDSingleton;
import br.com.pietroth.tsa.core.communication.MessageData;
import br.com.pietroth.tsa.core.communication.intention.Intention;
import br.com.pietroth.tsa.core.communication.event.Event;
import br.com.pietroth.tsa.core.communication.event.EventDispatcher;

public class IntentionGateway implements ConnectionReceivedListener {
    private final IntentionDecoder decoder;
    private final EventDispatcher dispatcher;

    public IntentionGateway(IntentionDecoder decoder, EventDispatcher dispatcher) {
        this.decoder = decoder;
        this.dispatcher = dispatcher;
    }

    @Override
    public void onConnectionReceived(Connection connection, byte[] data) {
        IntentionVD intentionVD = IntentionVDSingleton.get();

        Intention<? extends MessageData> intention = decoder.decode(data);
        int validate = intentionVD.validate(intention);

        if (validate >= 1) {
            Event<? extends MessageData> event = new Event<>(intention.getFamily(), intention.getType(), intention.getData());
            dispatcher.enqueue(event);
        }

    }
}