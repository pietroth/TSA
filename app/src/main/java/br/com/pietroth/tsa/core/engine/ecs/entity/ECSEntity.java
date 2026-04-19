package br.com.pietroth.tsa.core.engine.ecs.entity;

public interface ECSEntity {
    <T> T get(Class<T> component);
}
