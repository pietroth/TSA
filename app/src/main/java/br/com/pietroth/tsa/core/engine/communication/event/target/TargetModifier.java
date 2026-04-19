package br.com.pietroth.tsa.core.engine.communication.event.target;

import java.util.List;

import br.com.pietroth.tsa.core.engine.network.client.ClientId;

public interface TargetModifier {
    List<ClientId> toList();
}
