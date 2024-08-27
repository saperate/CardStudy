package Engine.Managers;

import org.json.JSONObject;
import org.json.JSONTokener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FileManager {
    private static FileManager instance;
    private String uDir = System.getProperty("user.dir");

    private FileManager(){

    }

    public static FileManager get(){
        if(instance == null){
            instance = new FileManager();
        }
        return instance;
    }

    public String getFullPath(String localPath){
        return uDir + "\\" + localPath;
    }

    public BufferedImage getBufferedImage(String path){
        try{
            return ImageIO.read(new URL(uDir + path));
        } catch (MalformedURLException e) {
            System.err.println("file:\\" + uDir + path);
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getBufferedImageAbsPath(String path){//Use when you already have the full path
        try{
            return ImageIO.read(new URL("file:\\" + path));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject getJsonFile(String path){
        try {
            FileReader reader = new FileReader(uDir + path);
            return new JSONObject(new JSONTokener(reader));
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file at: '" + uDir + path + "'.");
            throw new RuntimeException(e);
        }
    }

    public void saveJsonFile(String path, JSONObject obj){
        try {
            FileWriter file = new FileWriter(uDir + path);
            file.write(obj.toString());
            file.close();
        } catch (IOException e) {
            System.err.println("Could not write file at: '" + uDir + path + "'.");
            throw new RuntimeException(e);
        }
    }

}
