package br.com.pietroth.tsa.core.engine.ecs.entity;

public interface EntityConsumer {
    void accept(ECSEntity entity);
}
