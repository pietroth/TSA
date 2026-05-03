package br.com.pietroth.tsa.infrastructure.ecs.dominion;

import br.com.pietroth.tsa.core.engine.ecs.entity.ECSEntity;
import dev.dominion.ecs.api.Entity;

public class DominionEntity implements ECSEntity {
    private final Entity entity;
    private final int id;

    public DominionEntity(int id, Entity entity) {
        this.entity = entity;
        this.id = id;
    }

    public Entity raw() {
        return entity;
    }

    public <T> T getComponent(Class<T> component) {
        return entity.get(component);
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DominionEntity other)) return false;
        return entity.equals(other.entity);
    }

    @Override
    public int hashCode() {
        return entity.hashCode();
    }
}
