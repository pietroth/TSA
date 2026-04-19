package br.com.pietroth.tsa.core.engine.ecs;

import br.com.pietroth.tsa.core.engine.ecs.entity.EntityConsumer;
import br.com.pietroth.tsa.core.engine.ecs.entity.ECSEntity;

public interface ECSContainer {
    ECSEntity createEntity(Object... components);
    void deleteEntity(ECSEntity entity);
    void forEachEntityWith(Class<?>[] components, EntityConsumer consumer);
}
