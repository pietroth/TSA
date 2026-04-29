package br.com.pietroth.tsa.core.engine.communication.response;

import br.com.pietroth.tsa.core.engine.runtime.DataProcessingPipeline;

public class IRPublisher {
    private final DataProcessingPipeline processingPipeline;

    public IRPublisher(DataProcessingPipeline processingPipeline) {
        this.processingPipeline = processingPipeline;
    }

    public void publish(IR ir) {
        
    }
}
