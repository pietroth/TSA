package br.com.pietroth.tsa.core.game.communication;

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

    public static enum Physics {
        ENTITY_MOVED((byte) 10);

        private final byte id;
        private static final byte GLOBAL_ID = 8;

        Physics(byte id) {
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