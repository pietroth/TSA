package br.com.pietroth.tsa.core.engine.communication.event;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public class EventPublisher {
    private final EventDeliveryHandler deliveryHandler;

    public EventPublisher(EventDeliveryHandler deliveryHandler) {
        this.deliveryHandler = deliveryHandler;
    }

    public void publish(Event<? extends MIDFData> event) {
        EventDispatcherSingleton.get().enqueue(event);
        deliveryHandler.delivery(event);
    }
}
