package Engine.Utils.Event;

public interface EventListener {
    //Classes that have an event Listener need to implement this.
    //Classes that are event targets need to extend EventTarget. Refer to Input and devtools as an example.
    //Also, if you don't add the fucking event info chart I will break your kneecaps
    //
    //Devtools cannot have any event listener nor can it register any (Makes an infinite loop)
    void onEventFired(Event e);

    void onEventStarted(Event e);

    void onEventEnded(Event e);
}
