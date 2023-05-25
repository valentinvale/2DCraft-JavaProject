package Services;

import java.io.FileWriter;
import java.time.format.DateTimeFormatter;

public class AuditService {

    private static FileWriter writer;
    static {
        try {
            writer = new FileWriter("data\\audit.csv", true);
        } catch (Exception e) {
            System.out.println("Error while creating audit file: " + e.getMessage());
        }
    }
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static void writeAction(String action) {
        try {
            writer.append(action);
            writer.append(",");
            writer.append(java.time.LocalDateTime.now().format(formatter));
            writer.append("\n");
            writer.flush();
        } catch (Exception e) {
            System.out.println("Error while writing action: " + e.getMessage());
        }
    }

}
