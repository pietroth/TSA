package br.com.pietroth.tsa.core.ecs.entity;

public interface ECSEntity {
    <T> T get(Class<T> component);
}
