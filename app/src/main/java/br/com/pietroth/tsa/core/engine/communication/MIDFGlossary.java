package br.com.pietroth.tsa.core.engine.communication;

public class MIDFGlossary {
    public static enum Player {
        PLAYER_MOVED((byte) 10);

        private final byte id;      
        private static final byte GLOBAL_ID = 10;

        Player(byte id) {
            this.id = id;
        }

        public byte getId() {
            return id;
        }

        public static byte getGlobalId() {
            return GLOBAL_ID;
        }
    }
}