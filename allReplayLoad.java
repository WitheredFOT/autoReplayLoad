import java.awt.Desktop;  
import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class allReplayLoad {
    static Desktop desktop = Desktop.getDesktop();
    static String user = ""; // Just change this to whatever ur windows user is
    public static void main(String[] args) {
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
            return;
        }
        String string = ".osr";
        fileOpener(string);
        wait(5000);
        fileDeletor(string);

    }

    public static void fileOpener(String suffix){
        try {
            File folder = new File("C:\\Users\\"+user+"\\AppData\\Local\\osu!\\Replays");
            File[] files = folder.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(suffix);
                }
            });

            for (File file : files) {
                if (file.exists()) {
                    desktop.open(file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileDeletor(String suffix){
        try {
            File folder = new File("C:\\Users\\"+user+"\\AppData\\Local\\osu!\\Replays");
            File[] files = folder.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(suffix);
                }
            });

            for (File file : files) {
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void wait(int ms){
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}