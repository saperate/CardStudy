package Engine.Utils.Dev;

import java.util.Dictionary;
import java.util.Hashtable;

public class DevTools{
    private static DevTools instance;
    private Dictionary<String, Long> timers = new Hashtable<>();
    private Dictionary<Integer,String> eventTargetIds = new Hashtable<>();
    private int currUniqueInt = -1;

    private DevTools() {

    }

    public int addEventTarget(String targetName){
        int id = getNewUniqueInt();
        eventTargetIds.put(id, targetName);
        return id;
    }

    public String getEventTargetById(int id){
        if(id < 0 || eventTargetIds.get(id) == null){
            System.err.println("Incorrect Id: id was not registered or id was negative: " + id);
        }
        return eventTargetIds.get(id);
    }

    //Unique Id Code
    public int getLastUniqueInt(){
        return currUniqueInt;
    }

    public int getNewUniqueInt() {
        currUniqueInt++;
        return currUniqueInt;
    }


    //Timer code
    public void addTimer(String key) {
        if (timers.get(key) != null) {
            System.err.println("Tried to add a timer while it already existed. Overriding timer: " + key);
        }
        timers.put(key, System.currentTimeMillis());
    }

    //this is for checking on the timer while it runs, does not end it
    public long getTimer(String key) {
        if (timers.get(key) == null) {
            throw new RuntimeException("Did not create timer: " + key + " before registering it!");
        }
        long deltaT = System.currentTimeMillis() - timers.get(key);
        return timers.get(deltaT);
    }

    public long getTimerSeconds(String key) {
        if (timers.get(key) == null) {
            throw new RuntimeException("Did not create timer: " + key + " before registering it!");
        }
        long deltaT = System.currentTimeMillis() - timers.get(key);
        return toSeconds(timers.get(deltaT));
    }

    //use this to properly dispose of a timer
    public long endTimer(String key) {
        if (timers.get(key) == null) {
            throw new RuntimeException("Did not create timer: " + key + " before registering it!");
        }
        long deltaT = System.currentTimeMillis() - timers.get(key);
        timers.remove(key);
        return deltaT;
    }

    public long endTimerAnnounce(String key) {
        if (timers.get(key) == null) {
            throw new RuntimeException("Did not create timer: " + key + " before registering it!");
        }
        long deltaT = System.currentTimeMillis() - timers.get(key);
        timers.remove(key);
        System.out.println("Timer: " + key + " ended after " + deltaT + " ms");
        return deltaT;
    }

    public long endTimerSeconds(String key) {
        if (timers.get(key) == null) {
            throw new RuntimeException("Did not create timer: " + key + " before registering it!");
        }
        long deltaT = System.currentTimeMillis() - timers.get(key);
        timers.remove(key);
        return toSeconds(deltaT);
    }

    public long toSeconds(long ms) {
        return ms / 1000;
    }

    public int toSecondsRound(long ms) {
        return Math.round((float) ms / 1000);
    }

    public long toMillis(long s) {
        return s * 1000;
    }

    public void removeAllTimers() {
        throw new RuntimeException("Not yet implemented");
    }


    //Misc things
    public static void printArray(Object[] array){
        String str = "(";
        for (int i = 0; i < array.length; i++) {
            str += array[i] + ",";
        }
        System.out.println(str + "End)");
    }

    public static DevTools get() {
        if (instance == null) {
            instance = new DevTools();
        }
        return instance;
    }

}
