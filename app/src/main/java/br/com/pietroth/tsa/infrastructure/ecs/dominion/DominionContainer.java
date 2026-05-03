package br.com.pietroth.tsa.infrastructure.ecs.dominion;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.engine.ecs.entity.ECSEntity;
import br.com.pietroth.tsa.core.engine.ecs.entity.EntityConsumer;
import dev.dominion.ecs.api.Dominion;
import dev.dominion.ecs.api.Entity;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntStack;

public class DominionContainer implements ECSContainer {
    private final Dominion dominion;

    private final Int2ObjectMap<DominionEntity> entities;
    private final IntStack freeIds;
    private int nextId;

    public DominionContainer() {
        this.dominion = Dominion.create();
        this.entities = new Int2ObjectOpenHashMap<>();
        this.freeIds = new IntArrayList();
        this.nextId = 0;
    }

    @Override
    public ECSEntity createEntity(Object... components) {
        int id = freeIds.isEmpty() ? nextId++ : freeIds.popInt();
        
        Entity rawEntity = dominion.createEntity(components);
        DominionEntity entity = new DominionEntity(id, rawEntity);

        if (entities.put(id, entity) != null) {
            throw new IllegalStateException("Entity ID collision: " + id);
        }

        return entity;
    }

    @Override
    public void deleteEntity(ECSEntity entity) {
        DominionEntity dominionEntity = requireDominionEntity(entity);
        int id = dominionEntity.getId();

        DominionEntity removed = entities.remove(id);
        if (removed == null) {
            throw new IllegalStateException("Entity not found in container: " + id);
        }

        dominion.deleteEntity(dominionEntity.raw());
        freeIds.push(id);
    }

    @Override
    public ECSEntity getEntity(int id) {
        return entities.get(id);
    }

    @Override
    public boolean containsEntity(int id) {
        return entities.containsKey(id);
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
        for (DominionEntity value : entities.values()) {
            if (value.raw().equals(entity)) {
                return value;
            }
        }

        throw new IllegalStateException("Entity is not registered in entities");
    }

    private DominionEntity requireDominionEntity(ECSEntity entity) {
        if (!(entity instanceof DominionEntity dominionEntity)) {
            throw new IllegalArgumentException("Entity must be a DominionEntity");
        }
        return dominionEntity;
    }
}