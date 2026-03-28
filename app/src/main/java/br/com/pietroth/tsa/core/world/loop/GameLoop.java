package br.com.pietroth.tsa.core.world.loop;

import br.com.pietroth.tsa.core.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.ecs.component.PositionComponent;
import br.com.pietroth.tsa.core.ecs.component.VelocityComponent;
import br.com.pietroth.tsa.core.ecs.system.MovementSystem;
import br.com.pietroth.tsa.core.world.WorldConfiguration;
import br.com.pietroth.tsa.core.world.player.PlayerComponent;
import br.com.pietroth.tsa.core.event.*;
import br.com.pietroth.tsa.core.event.player.PlayerEvents;
import br.com.pietroth.tsa.core.event.player.playermoved.PlayerMovedCodec;
import br.com.pietroth.tsa.core.event.player.playermoved.PlayerMovedExecuter;
import br.com.pietroth.tsa.core.application.MovementUseCase;

public class GameLoop extends TicksPerSecondRunnable {

    private final ECSRuntime ecsRuntime;
    private final CodecRegistry codecRegistry;

    private EventDispatcher dispatcher;

    public GameLoop(ECSRuntime ecsRuntime, CodecRegistry codecRegistry) {
        super(WorldConfiguration.TPS);
        this.ecsRuntime = ecsRuntime;
        this.codecRegistry = codecRegistry;
    }

    @Override
    protected void initialize() {
        codecRegistry.register(
            (byte) EventIdentifier.Player.getGlobalId(),
            (byte) EventIdentifier.Player.PLAYER_MOVED.getId(),
            new PlayerMovedCodec()
        );

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

        playerEvents.publishPlayerMoved(5f, 0f);

        dispatcher.run();
    }

    @Override
    protected void tick() {
        ecsRuntime.tick();
        dispatcher.run();
    }
}