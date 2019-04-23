package accommodation.service;

import java.io.*;
import java.sql.Timestamp;

public class AuditService {

    public static void audit(String actiune){

        try (PrintWriter csv = new PrintWriter(new FileWriter("audit.csv",true));) {
            Timestamp time = new Timestamp(System.currentTimeMillis());

            StringBuilder linie = new StringBuilder();
            linie.append(actiune);
            linie.append(",");
            linie.append(time);
            linie.append("\n");
            csv.write(linie.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
