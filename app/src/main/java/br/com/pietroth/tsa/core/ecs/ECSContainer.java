package br.com.pietroth.tsa.core.ecs;

import br.com.pietroth.tsa.core.ecs.entity.ECSEntity;

public interface ECSContainer {
    ECSEntity createEntity(Object... components);
    void deleteEntity(ECSEntity entity);
    Iterable<ECSEntity> findEntitiesWith(Class<?>... components);
}
