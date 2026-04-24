package br.com.pietroth.tsa.core.engine.network.protocol;

import br.com.pietroth.tsa.core.engine.communication.intention.IntentionDecoder;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionVD;
import br.com.pietroth.tsa.core.engine.network.transport.Connection;
import br.com.pietroth.tsa.core.engine.network.transport.ConnectionReceivedListener;
import br.com.pietroth.tsa.core.engine.communication.intention.IntentionVDSingleton;
import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.communication.intention.Intention;
import br.com.pietroth.tsa.core.engine.communication.event.Event;
import br.com.pietroth.tsa.core.engine.communication.event.EventPublisher;

public class IntentionGateway implements ConnectionReceivedListener {
    private final IntentionDecoder decoder;

    public IntentionGateway(IntentionDecoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public void onConnectionReceived(Connection connection, byte[] data) {
        IntentionVD intentionVD = IntentionVDSingleton.get();
        System.out.println("Gateway raw bytes: " + data.length);

        Intention<? extends MIDFData> intention = decoder.decode(data, 10);

        System.out.println("Decoded intention family=" + (intention.getFamily() & 0xFF)
            + " type=" + (intention.getType() & 0xFF)
            + " data=" + intention.getData());

        int validate = intentionVD.validate(intention);
        System.out.println("Validation result=" + validate);

        if (validate >= 1) {
            // What must I do?
        }

    }
}