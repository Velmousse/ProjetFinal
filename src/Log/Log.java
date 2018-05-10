package Log;

import java.io.*;
import java.text.DateFormat;
import java.util.*;
import java.text.SimpleDateFormat;

public class Log {
    private PrintWriter sortie;
    private DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    private Date date = new Date();

    public Log() {
        try {
            sortie = new PrintWriter(new BufferedWriter(new FileWriter("Simulation_" + df.format(date) + ".dat")));
        } catch (IOException e) {

        }
    }

    public void writeLog(String text) {
        sortie.write(text);
    }

    public void saveLog() {
        sortie.flush();
    }
}
