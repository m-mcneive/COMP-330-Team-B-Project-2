
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.concurrent.TimeUnit;


public class DBMS {
    public static void main(String[] args) {
      //while (true) {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {

            Thread.currentThread().interrupt();
        }

          try {

              String host = "instpubs.sql";
              String username = "root";
              String password = "root";

              Connection connection = DriverManager.getConnection(host, username, password);

              Statement stmt = connection.createStatement();
              String query = "SELECT * FROM database";
              ResultSet rs = stmt.executeQuery(query);

              while (rs.next()) {
                String last_name = rs.getString("Last_Name");
                int default_room = rs.getInt("Default_room");
                int room = rs.getInt("Room");
                int status = rs.getInt("Status");

                //setConnection(last_name, default_room, room, status);
              }
          } catch (SQLException err) {
              System.out.println(err.getMessage());
          }
        //}
    }
}
