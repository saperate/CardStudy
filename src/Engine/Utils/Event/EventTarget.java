package Engine.Utils.Event;

import Engine.Utils.Dev.DevTools;

import java.util.ArrayList;

public abstract class EventTarget {
    private ArrayList<EventListener> eventListeners = new ArrayList<>();
    private int targetId;

    public EventTarget(String desiredTargetName){
        targetId = DevTools.get().addEventTarget(desiredTargetName);
    }

    public Event createEvent(int eventType, Object contents){
        return new Event(targetId,eventType,contents);
    }

    public void eventFire(Event e){
        for (EventListener eventListener : eventListeners){
            eventListener.onEventFired(e);
        }
    }

    public void eventFire(int eventType, Object contents){
        Event e = createEvent(eventType,contents);
        for (EventListener eventListener : eventListeners){
            eventListener.onEventFired(e);
        }
    }

    public void eventStart(Event e){
        for (EventListener eventListener : eventListeners){
            eventListener.onEventStarted(e);
        }
    }

    public void eventStart(int eventType, Object contents){
        Event e = createEvent(eventType,contents);
        for (EventListener eventListener : eventListeners){
            eventListener.onEventStarted(e);
        }
    }

    public void eventEnd(Event e){
        for (EventListener eventListener : eventListeners){
            eventListener.onEventEnded(e);
        }
    }

    public void eventEnd(int eventType, Object contents){
        Event e = createEvent(eventType,contents);
        for (EventListener eventListener : eventListeners){
            eventListener.onEventEnded(e);
        }
    }

    public EventListener registerEventListener(EventListener eventListener){
        eventListeners.add(eventListener);
        return eventListener;
    }

    public EventListener getEventListener(int id){
        if(id >= eventListeners.size()){
            throw new RuntimeException("Tried to get an eventListener before actually initializing it: ");
        }
        return eventListeners.get(id);
    }

    public void removeEventListener(EventListener eventListener){
        for (int i = 0; i < eventListeners.size(); i++) {
            if(eventListeners.get(i).equals(eventListener)){
                eventListeners.remove(i);
            }
        }
    }
}
