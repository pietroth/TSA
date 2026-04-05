package br.com.pietroth.tsa.infrastructure.ecs.dominion;

import java.util.ArrayList;
import java.util.List;

import br.com.pietroth.tsa.core.ecs.ECSContainer;
import br.com.pietroth.tsa.core.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.ecs.entity.ECSEntity;

public class DominionRuntime implements ECSRuntime {
    private final List<Runnable> systems = new ArrayList<>();

    private final DominionContainer container;

    public DominionRuntime() {
        container = new DominionContainer();
    }

    @Override
    public ECSEntity createEntity(Object... components) {
        return container.createEntity(components);
    }

    @Override
    public void deleteEntity(ECSEntity entity) {
        container.deleteEntity(entity);
    }

    @Override
    public void schedule(Runnable system) {
        systems.add(system);
    }

    @Override
    public void tick() {
        for (Runnable system : systems) {
            system.run();
        }
    }

    @Override
    public ECSContainer getContainer() {
        return container;
    }
    
}
