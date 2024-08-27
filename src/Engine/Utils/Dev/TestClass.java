package Engine.Utils.Dev;

import Engine.IO.Input;
import Engine.Utils.Event.Event;
import Engine.Utils.Event.EventListener;


import java.awt.event.MouseEvent;

public class TestClass  implements EventListener {

    public TestClass(){
        Input.get().registerEventListener(this);
    }



    @Override
    public void onEventFired(Event e) {

    }

    @Override
    public void onEventStarted(Event e) {
        //refer to the target class for these values
        if(DevTools.get().getEventTargetById(e.getSender()) == "input" && e.getEventType() == 1){
            MouseEvent mE = (MouseEvent) e.getContents();
            if(mE.getButton() == 1){

            }
        }

    }

    @Override
    public void onEventEnded(Event e) {

    }
}
