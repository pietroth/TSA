package br.com.pietroth.tsa.core.ecs;

import br.com.pietroth.tsa.core.ecs.entity.ECSEntity;

public interface ECSRuntime {
    ECSEntity createEntity(Object... object);
    void deleteEntity(ECSEntity entity);

    void schedule(Runnable system);
    void tick();

    ECSContainer getContainer();
}
