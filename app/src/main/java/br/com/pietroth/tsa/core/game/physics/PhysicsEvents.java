package br.com.pietroth.tsa.core.game.physics;

import br.com.pietroth.tsa.core.engine.communication.event.Event;
import br.com.pietroth.tsa.core.engine.communication.event.EventPublisherSingleton;
import br.com.pietroth.tsa.core.engine.communication.event.target.OneClient;
import br.com.pietroth.tsa.core.engine.communication.event.target.TargetScope;
import br.com.pietroth.tsa.core.game.communication.MIDFGlossary;
import br.com.pietroth.tsa.core.game.physics.movement.MoveData;

public class PhysicsEvents {
    public static void publish_entityMove(int originId, float sx, float sy) {
        MoveData data = new MoveData(sx, sy);
        Event<MoveData> event = new Event<MoveData>(
            MIDFGlossary.Physics.getGlobalId(),
            MIDFGlossary.Physics.ENTITY_MOVED.getId(), 
            data, 
            originId,
            new TargetScope(new OneClient(originId))
        );
        EventPublisherSingleton.get().publish(event);
    }
}
