package Entry;

import Engine.IO.Input;
import Engine.Managers.WindowManager;
import Engine.Utils.Dev.DevTools;
import Engine.Utils.Event.Event;
import Engine.Utils.Event.EventListener;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class App implements EventListener {
    public static boolean running = true;
    public static App instance;
    public void start(){
        WindowManager.get().init();

        Input.get().registerEventListener(this);
        run();
    }

    public void run(){
        while (running){
            update();
        }
        close();
    }

    public void update(){

    }

    public void close() {
        System.out.println("Closing..");
        WindowManager.get().saveSettings();
        WindowManager.get().dispose();
        System.exit(0);
    }


    @Override
    public void onEventFired(Event e) {

    }
    @Override
    public void onEventStarted(Event e) {
        //refer to the target class for these values
        if(DevTools.get().getEventTargetById(e.getSender()) == "input" && e.getEventType() == 0){
            KeyEvent kE = (KeyEvent) e.getContents();
            switch (kE.getKeyCode()){
                case 27:
                    close();
                    break;
                case 122:
                    WindowManager.get().fullscreen();
            }
            if(kE.getKeyCode() == 27){ //written in Input
                close();
            }
        }

    }

    @Override
    public void onEventEnded(Event e) {

    }

    private App(){
        instance = this;
        start();
    }

    public static App get(){
        if(instance == null){
            instance = new App();
        }
        return instance;
    }

    public static void main(String[] args) {
        App.get();
    }
}