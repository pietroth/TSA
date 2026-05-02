package br.com.pietroth.tsa.core.engine.communication;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;

public final class MIDFDataCodec {
    public static void encode(MemorySegment dest, byte family, byte type) {
        VH_FAMILY.set(dest, 0L, family);
        VH_TYPE.set(dest, 0L, type);
    }

    public static byte getFamily(MemorySegment segment) {
        return (byte) VH_FAMILY.get(segment, 0L);
    }

    public static byte getType(MemorySegment segment) {
        return (byte) VH_TYPE.get(segment, 0L);
    }

    private static final StructLayout HEADER_LAYOUT = MemoryLayout.structLayout(
        ValueLayout.JAVA_BYTE.withName("family"),
        ValueLayout.JAVA_BYTE.withName("type")
    );

    private static final VarHandle VH_FAMILY = HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("family"));
    private static final VarHandle VH_TYPE = HEADER_LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("type"));
}
