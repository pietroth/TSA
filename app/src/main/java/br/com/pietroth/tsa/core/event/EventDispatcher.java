package br.com.pietroth.tsa.core.event;

import java.util.ArrayDeque;
import java.util.Queue;

public class EventDispatcher implements Runnable {

    private final Queue<Event<? extends EventData>> current;
    private final Queue<Event<? extends EventData>> next;  

    private final EventExecuter<? extends EventData>[][] executers; 

    private boolean processing;

    @SuppressWarnings("unchecked")
    public EventDispatcher(int maxFamilies, int maxTypesPerFamily) {
        executers = new EventExecuter[maxFamilies][maxTypesPerFamily]; 
        current = new ArrayDeque<>();
        next = new ArrayDeque<>();
        processing = false;
    }

    public void register(byte family, byte type, EventExecuter<? extends EventData> executer) {
        executers[family & 0xFF][type & 0xFF] = executer;
    }

    @Override
    public void run() {
        processing = true;

        Event<? extends EventData> event;
        while ((event = current.poll()) != null) {
            dispatch(event);
        }

        processing = false;

        current.clear(); 
        current.addAll(next);
        next.clear();
    }

    private void dispatch(Event<? extends EventData> event) {
        byte family = event.getFamily();
        byte type = event.getType();

        EventExecuter<? extends EventData> executer = executers[family & 0xFF][type & 0xFF];

        if (executer != null) {
            dispatchEvent(event, executer);
        }
    }

    private <T extends EventData> void dispatchEvent(Event<T> event, EventExecuter<? extends EventData> executer) {
        @SuppressWarnings("unchecked")
        EventExecuter<T> typedExecuter = (EventExecuter<T>) executer;
        typedExecuter.execute(event.getData());
    }

    public void enqueue(Event<? extends EventData> event) {
        if (processing) {
            next.add(event);
        } else {
            current.add(event);
        }
    }
}