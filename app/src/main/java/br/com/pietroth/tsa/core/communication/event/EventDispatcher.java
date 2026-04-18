package br.com.pietroth.tsa.core.communication.event;

import java.util.ArrayDeque;
import java.util.Queue;

import br.com.pietroth.tsa.core.communication.MIDFData;

public class EventDispatcher implements Runnable {

    private final Queue<Event<? extends MIDFData>> current;
    private final Queue<Event<? extends MIDFData>> next;  

    private final EventExecuter<? extends MIDFData>[][] executers; 

    private boolean processing;

    @SuppressWarnings("unchecked")
    public EventDispatcher(int maxFamilies, int maxTypesPerFamily) {
        executers = new EventExecuter[maxFamilies][maxTypesPerFamily]; 
        current = new ArrayDeque<>();
        next = new ArrayDeque<>();
        processing = false;
    }

    public void register(byte family, byte type, EventExecuter<? extends MIDFData> executer) {
        executers[family & 0xFF][type & 0xFF] = executer;
    }

    @Override
    public void run() {
        processing = true;

        Event<? extends MIDFData> event;
        while ((event = current.poll()) != null) {
            dispatch(event);
        }

        processing = false;

        current.clear(); 
        current.addAll(next);
        next.clear();
    }

    private void dispatch(Event<? extends MIDFData> event) {
        byte family = event.getFamily();
        byte type = event.getType();

        EventExecuter<? extends MIDFData> executer = executers[family & 0xFF][type & 0xFF];

        if (executer != null) {
            dispatchEvent(event, executer);
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends MIDFData> void dispatchEvent(Event<? extends MIDFData> event, EventExecuter<? extends MIDFData> executer) {
        ((EventExecuter<T>) executer).execute((T) event.getData());
    }

    public void enqueue(Event<? extends MIDFData> event) {
        System.out.println("Enqueue event family=" + (event.getFamily() & 0xFF)
            + " type=" + (event.getType() & 0xFF));

        if (processing) {
            next.add(event);
        } else {
            current.add(event);
        }
    }
}