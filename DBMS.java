
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

//import java.util.concurrent.TimeUnit;


public class DBMS {
    public static void main(String[] args) {
    	System.out.println("Starting");
    	
    	//Currently runs every -- 5 seconds
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {

            Thread.currentThread().interrupt();
        }

          try {

        	  //Connection info for databse
              String host = "jdbc:mysql://localhost/DoyleHall";	//host address
              String username = "root";	//username - local host
              String password = "GroupB171110";	//password
              

              Connection connection = DriverManager.getConnection(host, username, password);
              System.out.println("Database connected!\n");
              
              //SQL query
              Statement stmt = connection.createStatement();
              //Current table -- faculty
              String query = "SELECT * FROM faculty";
              ResultSet rs = stmt.executeQuery(query);

              //Reads all info from table made in query
              while (rs.next()) {
                String last_name = rs.getString("Name");
                int room = rs.getInt("Room_Num");
                String status = rs.getString("Room_Status");
                System.out.println(last_name + " " + room + " " + status);
              }



          } catch (SQLException err) {
              System.out.println(err.getMessage());
          }
      }
}
