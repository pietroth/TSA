package br.com.pietroth.tsa.core.network.protocol;

import br.com.pietroth.tsa.core.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.communication.intention.IntentionVD;
import br.com.pietroth.tsa.core.network.transport.Connection;
import br.com.pietroth.tsa.core.network.transport.ConnectionReceivedListener;
import br.com.pietroth.tsa.core.communication.intention.IntentionVDSingleton;
import br.com.pietroth.tsa.core.communication.MIDFData;
import br.com.pietroth.tsa.core.communication.intention.Intention;
import br.com.pietroth.tsa.core.communication.event.Event;
import br.com.pietroth.tsa.core.communication.event.EventDispatcherSingleton;

public class IntentionGateway implements ConnectionReceivedListener {
    private final IntentionDecoder decoder;

    public IntentionGateway(IntentionDecoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public void onConnectionReceived(Connection connection, byte[] data) {
        IntentionVD intentionVD = IntentionVDSingleton.get();
        System.out.println("Gateway raw bytes: " + data.length);

        Intention<? extends MIDFData> intention = decoder.decode(data);

        System.out.println("Decoded intention family=" + (intention.getFamily() & 0xFF)
            + " type=" + (intention.getType() & 0xFF)
            + " data=" + intention.getData());

        int validate = intentionVD.validate(intention);
        System.out.println("Validation result=" + validate);

        if (validate >= 1) {
            Event<? extends MIDFData> event = new Event<>(intention.getFamily(), intention.getType(), intention.getData());
            EventDispatcherSingleton.get().enqueue(event);
        }

    }
}