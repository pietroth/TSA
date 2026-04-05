package br.com.pietroth.tsa.core.ecs;

import br.com.pietroth.tsa.core.ecs.entity.EntityConsumer;
import br.com.pietroth.tsa.core.ecs.entity.ECSEntity;

public interface ECSContainer {
    ECSEntity createEntity(Object... components);
    void deleteEntity(ECSEntity entity);
    void forEachEntityWith(Class<?>[] components, EntityConsumer consumer);
}
