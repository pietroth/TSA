package br.com.pietroth.tsa.core.engine.runtime;

public abstract class TicksPerSecondRunnable implements Runnable {

    private boolean running;
    private final double TICKS_PER_SECOND;
    private final double TIME_PER_TICK; 

    public TicksPerSecondRunnable(double ticksPerSecond) {
        running = true;
        this.TICKS_PER_SECOND = ticksPerSecond;
        this.TIME_PER_TICK = 1000000000.0 / TICKS_PER_SECOND; // nanoseconds per tick
    }

    protected abstract void initialize();

    @Override
    public void run() {
        initialize();

        long lastTime = System.nanoTime();
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / TIME_PER_TICK;
            lastTime = now;

            while (delta >= 1) {
                tick();
                delta--;
            }
        }
    }

    protected abstract void tick(); // game update

    public void stop() {
        running = false;
    }
}
