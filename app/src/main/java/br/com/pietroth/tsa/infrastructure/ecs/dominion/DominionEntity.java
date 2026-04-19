package br.com.pietroth.tsa.infrastructure.ecs.dominion;

import br.com.pietroth.tsa.core.engine.ecs.entity.ECSEntity;
import dev.dominion.ecs.api.Entity;

public class DominionEntity implements ECSEntity {
    private final Entity entity;

    public DominionEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity raw() {
        return entity;
    }

    public <T> T get(Class<T> component) {
        return entity.get(component);
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
