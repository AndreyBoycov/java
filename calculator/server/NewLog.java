package calculator.server;

import calculator.server.logger.Logging;

import java.io.File;
import java.io.IOException;

/**
 * Created by boecn on 12.05.2017.
 */
public class NewLog extends Thread {
    @Override
    public void run() {
        try {
            Logging.file = new File(Logging.catalog+Logging.countLogFile+".txt");
            if(!Logging.file.exists())
                Logging.file.createNewFile();
            Logging.logBuffer=new StringBuilder();
            Logging.countLogFile=0;
            Logging.countLogFile++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
