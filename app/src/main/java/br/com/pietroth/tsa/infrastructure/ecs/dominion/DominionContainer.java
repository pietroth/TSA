package br.com.pietroth.tsa.infrastructure.ecs.dominion;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.engine.ecs.entity.ECSEntity;
import br.com.pietroth.tsa.core.engine.ecs.entity.EntityConsumer;
import dev.dominion.ecs.api.Dominion;
import dev.dominion.ecs.api.Entity;

public class DominionContainer implements ECSContainer {
    private final Dominion dominion;

    public DominionContainer() {
        this.dominion = Dominion.create();
    }

    @Override
    public ECSEntity createEntity(Object... components) {
        Entity entity = dominion.createEntity(components);
        return new DominionEntity(entity);
    }

    @Override
    public void deleteEntity(ECSEntity entity) {
        DominionEntity dominionEntity = (DominionEntity) entity;
        dominion.deleteEntity(dominionEntity.raw());
    }

    @Override
    public void forEachEntityWith(Class<?>[] componentTypes, EntityConsumer consumer) {
        if (componentTypes == null || componentTypes.length == 0) {
            throw new IllegalArgumentException("At least one component type must be provided.");
        }

        switch (componentTypes.length) {
            case 1:
                dominion.findEntitiesWith(componentTypes[0])
                        .forEach(r -> consumer.accept(wrapEntity(r.entity())));
                return;

            case 2:
                dominion.findEntitiesWith(componentTypes[0], componentTypes[1])
                        .forEach(r -> consumer.accept(wrapEntity(r.entity())));
                return;

            case 3:
                dominion.findEntitiesWith(componentTypes[0], componentTypes[1], componentTypes[2])
                        .forEach(r -> consumer.accept(wrapEntity(r.entity())));
                return;
    
            case 4:
                dominion.findEntitiesWith(componentTypes[0], componentTypes[1], componentTypes[2], componentTypes[3])
                        .forEach(r -> consumer.accept(wrapEntity(r.entity())));
                return;

            case 5:
                dominion.findEntitiesWith(componentTypes[0], componentTypes[1], componentTypes[2], componentTypes[3], componentTypes[4])
                        .forEach(r -> consumer.accept(wrapEntity(r.entity())));
                return;

            case 6:
                dominion.findEntitiesWith(componentTypes[0], componentTypes[1], componentTypes[2], componentTypes[3], componentTypes[4], componentTypes[5])
                        .forEach(r -> consumer.accept(wrapEntity(r.entity())));
                return;

            default:
                throw new IllegalArgumentException("Dominion supports a maximum of 6 components per query.");
        }
    }

    private ECSEntity wrapEntity(Entity entity) {
        return new DominionEntity(entity);
    }
}