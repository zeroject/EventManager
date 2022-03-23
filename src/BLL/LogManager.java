package BLL;

import java.io.File;
import java.io.IOException;

public class LogManager {

    public LogManager(){

    }

    public static void main(String[] args) throws IOException {
        checkLogFile("sheit");
    }

    public static void checkLogFile(String activity) throws IOException {
        File dir = new File("");
        dir.mkdirs();
        File tempFile = new File(dir,"EventManager/ActivityLog.txt");

        if (tempFile.exists()){
            logActivity(activity);
        }else{
            File logFile = new File(dir,"ActivityLog.txt");
            logFile.createNewFile();
            logActivity(activity);
        }
    }

    public static void logActivity(String activity){

    }

}
