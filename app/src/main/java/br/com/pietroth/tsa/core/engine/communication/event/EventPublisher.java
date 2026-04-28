package br.com.pietroth.tsa.core.engine.communication.event;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;
import br.com.pietroth.tsa.core.engine.runtime.DataProcessingPipeline;

public class EventPublisher {
    private final DataProcessingPipeline processingPipeline;

    public EventPublisher(DataProcessingPipeline processingPipeline) {
        this.processingPipeline = processingPipeline;
    }

    public void publish(Event<? extends MIDFData> event) {
        processingPipeline.processEvent(event);
    }
}
