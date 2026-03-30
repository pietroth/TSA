package br.com.pietroth.tsa.infrastructure.ecs.dominion;

import br.com.pietroth.tsa.core.ecs.ECSContainer;
import br.com.pietroth.tsa.core.ecs.entity.ECSEntity;
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
    public Iterable<ECSEntity> findEntitiesWith(Class<?>... componentTypes) {
        if (componentTypes == null || componentTypes.length == 0) {
            throw new IllegalArgumentException("At least one component type must be provided.");
        }

        switch (componentTypes.length) {
            case 1:
                return dominion.findEntitiesWith(componentTypes[0])
                        .stream()
                        .map(r -> wrapEntity(r.entity()))
                        .toList();

            case 2:
                return dominion.findEntitiesWith(componentTypes[0], componentTypes[1])
                        .stream()
                        .map(r -> wrapEntity(r.entity()))
                        .toList();

            case 3:
                return dominion.findEntitiesWith(componentTypes[0], componentTypes[1], componentTypes[2])
                        .stream()
                        .map(r -> wrapEntity(r.entity()))
                        .toList();

            case 4:
                return dominion.findEntitiesWith(componentTypes[0], componentTypes[1], componentTypes[2], componentTypes[3])
                        .stream()
                        .map(r -> wrapEntity(r.entity()))
                        .toList();

            case 5:
                return dominion.findEntitiesWith(componentTypes[0], componentTypes[1], componentTypes[2], componentTypes[3], componentTypes[4])
                        .stream()
                        .map(r -> wrapEntity(r.entity()))
                        .toList();

            case 6:
                return dominion.findEntitiesWith(componentTypes[0], componentTypes[1], componentTypes[2], componentTypes[3], componentTypes[4], componentTypes[5])
                        .stream()
                        .map(r -> wrapEntity(r.entity()))
                        .toList();

            default:
                throw new IllegalArgumentException("Dominion supports a maximum of 6 components per query.");
        }
    }

    private ECSEntity wrapEntity(Entity entity) {
        return new DominionEntity(entity);
    }
}