package br.com.pietroth.tsa.core;

import br.com.pietroth.tsa.core.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.ecs.component.PositionComponent;
import br.com.pietroth.tsa.core.ecs.component.VelocityComponent;
import br.com.pietroth.tsa.core.ecs.system.MovementSystem;
import br.com.pietroth.tsa.core.world.WorldConfiguration;
import br.com.pietroth.tsa.core.world.player.PlayerComponent;
import br.com.pietroth.tsa.core.event.*;
import br.com.pietroth.tsa.core.event.codec.CodecRegistry;
import br.com.pietroth.tsa.core.event.codec.Codecs;
import br.com.pietroth.tsa.core.event.player.PlayerEvents;
import br.com.pietroth.tsa.core.event.player.playermoved.PlayerMovedExecuter;
import br.com.pietroth.tsa.core.application.MovementUseCase;

public class GameLoop extends TicksPerSecondRunnable {

    private final ECSRuntime ecsRuntime;
    private final CodecRegistry registry;

    private EventDispatcher dispatcher;

    public GameLoop(ECSRuntime ecsRuntime, CodecRegistry registry) {
        super(WorldConfiguration.TPS);
        this.ecsRuntime = ecsRuntime;
        this.registry = registry;
    }

    @Override
    protected void initialize() {
        registerCodecs(registry);

        ecsRuntime.createEntity(
            new PlayerComponent(1),
            new PositionComponent(0, 0),
            new VelocityComponent(0, 0)
        );

        dispatcher = new EventDispatcher(256, 256);

        dispatcher.register(
            (byte) EventIdentifier.Player.getGlobalId(),
            (byte) EventIdentifier.Player.PLAYER_MOVED.getId(),
            new PlayerMovedExecuter(new MovementUseCase(ecsRuntime.getContainer()))
        );

        PlayerEvents playerEvents = new PlayerEvents(dispatcher);

        ecsRuntime.schedule(new MovementSystem(ecsRuntime.getContainer()));

        playerEvents.publish_PlayerMoved(5f, 0f);

        dispatcher.run();
    }

    @Override
    protected void tick() {
        ecsRuntime.tick();
        dispatcher.run();
    }

    private void registerCodecs(CodecRegistry registry) {
        Codecs.registerCodecs(registry);
    }
}