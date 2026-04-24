package br.com.pietroth.tsa.core.engine.usecase;

import br.com.pietroth.tsa.core.engine.communication.MIDFData;

public class UseCaseRouter {
    private final UseCase<?>[] useCases;

    public UseCaseRouter() {
        this.useCases = new UseCase[4096];
    }

    public void register(int family, int type, UseCase<?> useCase) {
        if (family < 0 || family >= 64) throw new IllegalStateException("The maximum family value must be between 0 and 63.");
        if (type < 0 || type >= 64) throw new IllegalStateException("The maximum type value must be between 0 and 63.");
        int key = pack(family, type) & 0xFFF;
        useCases[key] = useCase;
    }

    public void route(int family, int type, MIDFData data) {
        int key = pack(family, type) & 0xFFF;

        @SuppressWarnings("unchecked")
        UseCase<MIDFData> useCase = (UseCase<MIDFData>) useCases[key];

        if (useCase == null) {
            throw new RuntimeException("No UseCase for key " + key);
        }

        useCase.execute(data);
    }

    private static int pack(int family, int type) {
        if ((family & ~0x3F) != 0 || (type & ~0x3F) != 0) {
            throw new IllegalArgumentException("family/type out of range");
        }
        return ((family & 0x3F) << 6) | (type & 0x3F);
    }
}
