package Engine.Utils.Event;

public class Event {
    private Object contents;
    private int sender, eventType;

    public Event(int sender, int eventType, Object contents) {
        this.sender = sender;
        this.contents = contents;
        this.eventType = eventType;
    }

    //Only putting Getters since this class should not live after it gives its info
    public int getSender() {
        return sender;
    }

    public Object getContents() {
        return contents;
    }

    //To know what the event type means go to the class that sent the event, and it should have a definition for every event type
    public int getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return "Event: target:" + sender + " Type:" + eventType + " Contents:" + contents;
    }
}
