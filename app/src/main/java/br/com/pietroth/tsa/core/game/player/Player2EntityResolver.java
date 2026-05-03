package br.com.pietroth.tsa.core.game.player;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;

public class Player2EntityResolver {
    private final Int2IntMap playerToEntityMap;

    public Player2EntityResolver() {
        playerToEntityMap = new Int2IntOpenHashMap();
    }    

    public void bind(int playerId, int entityId) {
        playerToEntityMap.put(playerId, entityId);
    }

    public void unbind(int playerId) {
        playerToEntityMap.remove(playerId);
    }

    public int resolve(int playerId) {
        if (!playerToEntityMap.containsKey(playerId)) {
            throw new IllegalStateException("No entity bound to playerId " + playerId);
        }
        return playerToEntityMap.get(playerId);
    }

    public boolean hasPlayer(int playerId) {
        return playerToEntityMap.containsKey(playerId);
    }
}
