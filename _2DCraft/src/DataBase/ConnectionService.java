package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionService {

    public static Connection getConnection() {

        try{
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String user = "utilizator";
            String password = "parola";

            return DriverManager.getConnection(url, user, password);
        }
        catch (Exception e){
            System.out.println("Error while connecting to database: " + e.getMessage());
            return null;
        }

    }

}
