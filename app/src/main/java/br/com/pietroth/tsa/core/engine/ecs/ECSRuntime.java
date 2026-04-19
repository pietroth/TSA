package br.com.pietroth.tsa.core.engine.ecs;

import br.com.pietroth.tsa.core.engine.ecs.entity.ECSEntity;

public interface ECSRuntime {
    ECSEntity createEntity(Object... object);
    void deleteEntity(ECSEntity entity);

    void schedule(Runnable system);
    void tick();

    ECSContainer getContainer();
}
