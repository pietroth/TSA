package br.com.pietroth.tsa.core.engine.world;

import java.time.LocalDateTime;

public class WorldData {
    private String name;
    private final LocalDateTime creationDate;
    private final int seed;

    public WorldData(String name, LocalDateTime creationDate, int seed) {
        this.name = name;
        this.creationDate = creationDate;
        this.seed = seed;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public int getSeed() {
        return seed;
    }

    public void changeName(String name) {
        this.name = name;
    }
}
