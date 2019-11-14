
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

//import java.util.concurrent.TimeUnit;


public class DBMS {
    public static void main(String[] args) {
      //while (true) {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {

            Thread.currentThread().interrupt();
        }

          try {

              //Class.forName("com.mysql.jdbc.DoyleHall");
              String host = "jdbc:mysql://localhost/DoyleHall";
              String username = "root";
              String password = "GroupB171110";


              Connection connection = DriverManager.getConnection(host, username, password);
              System.out.println("Database connected!");
              
              Statement stmt = connection.createStatement();
              String query = "SELECT * FROM faculty";
              ResultSet rs = stmt.executeQuery(query);

              
              while (rs.next()) {
                String last_name = rs.getString("Name");
                //int default_room = rs.getInt("Default_room");
                int room = rs.getInt("Room_Num");
                String status = rs.getString("Room_Status");
                System.out.println(last_name);
              }

              /*
              Connection connection = DriverManager.getConnection(host, username, password);
              //System.out.println("Here1");
              Statement stmt = connection.createStatement();
              String query = "SELECT * FROM faculty";
              ResultSet rs = stmt.executeQuery(query);

              while (rs.next()) {
                String last_name = rs.getString("Last_Name");
                int default_room = rs.getInt("Default_room");
                int room = rs.getInt("Room");
                int status = rs.getInt("Status");
*/
                //setConnection(last_name, default_room, room, status);
                /*

                MysqlDataSource dataSource = new MysqlDataSource();
                dataSource.setUser("root");
                dataSource.setPassword("GroupB171110");
                dataSource.setServerName("jdbc:mysql://localhost/DoyleHall");*/
              //}

          } catch (SQLException err) {
              //System.out.println(err.getMessage());
          }
        //}
    }
}
