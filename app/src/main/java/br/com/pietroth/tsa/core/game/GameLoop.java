package br.com.pietroth.tsa.core.game;

import java.io.OutputStream;
import java.util.concurrent.Executors;

import br.com.pietroth.tsa.core.engine.ecs.ECSRuntime;
import br.com.pietroth.tsa.core.engine.TicksPerSecondRunnable;
import br.com.pietroth.tsa.core.engine.network.NetworkAggregatorSingleton;
import br.com.pietroth.tsa.core.engine.network.client.Client;
import br.com.pietroth.tsa.core.engine.network.client.ClientLCManager;
import br.com.pietroth.tsa.core.engine.network.transport.Server;
import br.com.pietroth.tsa.core.game.physics.movement.MovementSystem;
import br.com.pietroth.tsa.core.game.physics.movement.PositionComponent;
import br.com.pietroth.tsa.core.game.physics.movement.VelocityComponent;
import br.com.pietroth.tsa.core.game.player.PlayerComponent;
import br.com.pietroth.tsa.infrastructure.network.tcp.TCPServer;

public class GameLoop extends TicksPerSecondRunnable {
    private final ECSRuntime ecsRuntime;
    private final ClientLCManager clientLCManager;
    private Server server;

    private OutputStream[] activeStreams = new OutputStream[0];

    private GameLoop(Builder builder) {
        super(20);
        this.ecsRuntime = builder.ecsRuntime;
        this.clientLCManager = builder.clientLCManager;
    }

    @Override
    protected void initialize() {
        scheduleSystems();

        ecsRuntime.createEntity(
            new PlayerComponent(1),
            new PositionComponent(0, 0),
            new VelocityComponent(0, 0)
        );

        server = TCPServer.builder()
            .port(5555)
            .clientPool(Executors.newCachedThreadPool())
            .build();
        server.subscribe(clientLCManager);
        new Thread(server).start();
    }

    @Override
    protected void tick() {
        ecsRuntime.tick();

        Client[] clients = clientLCManager.getClients();
        if (activeStreams.length != clients.length) {
            activeStreams = new OutputStream[clients.length];
        }

        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                activeStreams[i] = clients[i].getConnection().getOutputStream();
            }
            else {
                activeStreams[i] = null;
            }
        }

        NetworkAggregatorSingleton.get().flushAll(activeStreams);
    }

    private void scheduleSystems() {
        ecsRuntime.schedule(new MovementSystem(ecsRuntime.getContainer()));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ECSRuntime ecsRuntime;
        private ClientLCManager clientLCManager;

        public Builder ecsRuntime(ECSRuntime ecsRuntime) {
            this.ecsRuntime = ecsRuntime;
            return this;
        }

        public Builder clientLCManager(ClientLCManager clientLCManager) {
            this.clientLCManager = clientLCManager;
            return this;
        }

        public GameLoop build() {
            if (ecsRuntime == null) {
                throw new IllegalStateException("ECSRuntime must be provided");
            }
            if (clientLCManager == null) {
                throw new IllegalStateException("ClientLCManager must be provided");
            }

            return new GameLoop(this);
        }
    }
}
