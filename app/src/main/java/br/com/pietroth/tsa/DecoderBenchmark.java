package br.com.pietroth.tsa;

import org.openjdk.jmh.annotations.*;
import java.lang.foreign.*;
import java.lang.invoke.VarHandle;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput) // Mede operações por segundo
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
@Fork(2)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
public class DecoderBenchmark {

    private byte[] raw;
    private MemorySegment segment;
    
    private static final StructLayout LAYOUT = MemoryLayout.structLayout(
        ValueLayout.JAVA_INT_UNALIGNED.withName("correlationId"),
        ValueLayout.JAVA_SHORT_UNALIGNED.withName("intentionId")
    );
    
    private static final VarHandle VH_CORR = LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("correlationId"));
    private static final VarHandle VH_INTENT = LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("intentionId"));

    @Setup
    public void setup() {
        raw = new byte[]{0, 0, 0, 42, 0, 10}; // Exemplo de dados
        segment = MemorySegment.ofArray(raw);
    }

    @Benchmark
    public int manualBitShifting() {
        int offset = 0;
        int correlationId = (raw[offset++] & 0xFF) << 24 |
                            (raw[offset++] & 0xFF) << 16 |
                            (raw[offset++] & 0xFF) << 8  |
                            (raw[offset++] & 0xFF);
        int intentionId = ((raw[offset++] & 0xFF) << 8) |
                           (raw[offset++] & 0xFF);
        return correlationId + intentionId; // Simula uso dos dados
    }

    @Benchmark
    public int ffmWithWrapper() {
        // O que o "arrogante" disse: o custo de criar este wrapper pode pesar
        MemorySegment seg = MemorySegment.ofArray(raw);
        int correlationId = (int) VH_CORR.get(seg, 0L);
        short intentionId = (short) VH_INTENT.get(seg, 0L);
        return correlationId + intentionId;
    }

    @Benchmark
    public int ffmDirect() {
        // Cenário "Spaceship": o dado já é um segmento
        int correlationId = (int) VH_CORR.get(segment, 0L);
        short intentionId = (short) VH_INTENT.get(segment, 0L);
        return correlationId + intentionId;
    }
}
