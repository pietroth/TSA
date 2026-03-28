package br.com.pietroth.tsa.core.ecs;

import java.util.stream.Stream;

import br.com.pietroth.tsa.core.ecs.entity.ECSEntity;

public interface ECSContainer {
    ECSEntity createEntity(Object... components);
    void deleteEntity(ECSEntity entity);
    Stream<ECSEntity> findEntitiesWith(Class<?>... components);
}
