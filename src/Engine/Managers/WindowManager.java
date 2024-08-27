package Engine.Managers;

import Engine.IO.Input;
import Engine.Math.Vector.Vector2i;
import Entry.App;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowManager extends JFrame  implements WindowListener {
    public static WindowManager instance;
    private static final String path = "\\Save\\settings.json";
    private JFrame frame;
    private boolean fullscreen;
    private Vector2i location,size;

    private WindowManager(){

    }

    public void init(){
        //Load the config file
        JSONObject obj = FileManager.get().getJsonFile(path);
        if(obj.isEmpty()){
            genSettings(obj);
        }
        JSONObject gSettings = obj.getJSONObject("graphicSettings");
        fullscreen = gSettings.getBoolean("fullscreen");
        location = new Vector2i(gSettings.getInt("locationX"),gSettings.getInt("locationZ"));
        size = new Vector2i(gSettings.getInt("sizeX"),gSettings.getInt("sizeZ"));

        initFrame();
    }

    private void initFrame(){
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        frame = new JFrame(getTitle());
        frame.setExtendedState(fullscreen ? JFrame.MAXIMIZED_BOTH : JFrame.NORMAL);
        frame.setUndecorated(fullscreen);
        frame.setSize(size.getX(), size.getZ());
        frame.setLocation(location.getX(), location.getZ());
        frame.addWindowListener(this);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Input.get().setFrame(frame);
        addComponentListener();

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }


    //Might make a settings manager for that but for now there are only graphical settings
    public void saveSettings(){
        JSONObject obj = new JSONObject();
        JSONObject graphics = new JSONObject();

        graphics.put("fullscreen", fullscreen);

        graphics.put("locationX",location.getX());
        graphics.put("locationZ",location.getZ());
        graphics.put("sizeX",size.getX());
        graphics.put("sizeZ",size.getZ());

        obj.put("graphicSettings",graphics);

        FileManager.get().saveJsonFile(path,obj);
    }

    //Generates the file with defaults
    //Limitations:
    //--File has to exist
    //--File has to contain {}
    public void genSettings(JSONObject obj){
        JSONObject graphics = new JSONObject();

        graphics.put("fullscreen", false);

        graphics.put("locationX", 500);
        graphics.put("locationZ", 200);
        graphics.put("sizeX", 500);
        graphics.put("sizeZ", 500);

        obj.put("graphicSettings",graphics);

        FileManager.get().saveJsonFile(path,obj);
    }

    public void fullscreen() {
        fullscreen(!fullscreen);
    }

    public void fullscreen(boolean val) {
        fullscreen = val;
        frame.dispose();
        initFrame();
    }

    public String getTitle(){
        return "CardStudy";
    }

    public void dispose(){
        frame.dispose();
    }

    public static WindowManager get() {
        if(instance == null){
            instance = new WindowManager();
        }
        return instance;
    }

    public void addComponentListener(){
        frame.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = (Component)e.getSource();
                if(!fullscreen) {
                    size.set(c.getWidth(), c.getHeight());
                }
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                Component c = (Component)e.getSource();
                if(!fullscreen){
                    location.set(c.getX(),c.getY());
                }
            }
        });
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        App.get().close();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
