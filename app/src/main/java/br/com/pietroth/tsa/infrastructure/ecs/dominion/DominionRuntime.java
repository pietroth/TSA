package br.com.pietroth.tsa.infrastructure.ecs.dominion;

import br.com.pietroth.tsa.core.engine.ecs.ECSContainer;
import br.com.pietroth.tsa.core.engine.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.engine.ecs.entity.ECSEntity;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;

public class DominionRuntime implements ECSRuntime {
    private final ObjectList<Runnable> systems;
    private final DominionContainer container;

    public DominionRuntime() {
        systems = new ObjectArrayList<>();
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
