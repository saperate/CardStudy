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

public class WindowManager extends JFrame implements WindowListener {
    public static WindowManager instance;
    private static final String path = "\\Save\\settings.json";
    private JFrame frame;
    private Vector2i location;
    private final Vector2i size = new Vector2i(500);

    private WindowManager() {

    }

    public void init() {
        //Load the config file
        JSONObject obj = FileManager.get().getJsonFile(path);
        if (obj.isEmpty()) {
            genSettings(obj);
        }
        JSONObject gSettings = obj.getJSONObject("graphicSettings");
        location = new Vector2i(gSettings.getInt("locationX"), gSettings.getInt("locationZ"));

        initFrame();
    }

    private void initFrame() {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        frame = new JFrame(getTitle());
        frame.setExtendedState(JFrame.NORMAL);
        frame.setSize(size.getX(), size.getZ());
        frame.setLocation(location.getX(), location.getZ());
        frame.addWindowListener(this);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Input.get().setFrame(frame);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.revalidate();
        frame.repaint();
    }


    //Might make a settings manager for that but for now there are only graphical settings
    public void saveSettings() {
        JSONObject obj = new JSONObject();
        JSONObject graphics = new JSONObject();

        graphics.put("locationX", location.getX());
        graphics.put("locationZ", location.getZ());

        obj.put("graphicSettings", graphics);

        FileManager.get().saveJsonFile(path, obj);
    }

    //Generates the file with defaults
    //Limitations:
    //--File has to exist
    //--File has to contain {}
    public void genSettings(JSONObject obj) {
        JSONObject graphics = new JSONObject();

        graphics.put("locationX", 500);
        graphics.put("locationZ", 200);

        obj.put("graphicSettings", graphics);

        FileManager.get().saveJsonFile(path, obj);
    }


    public String getTitle() {
        return "CardStudy";
    }

    public void dispose() {
        frame.dispose();
    }

    public static WindowManager get() {
        if (instance == null) {
            instance = new WindowManager();
        }
        return instance;
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
