
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.Map;

//import java.util.concurrent.TimeUnit;

public class DBMS {
    public static void main(String[] args) {
        Map map = new Map(15);
        System.out.println("Starting");
        try {

            //Connection info for databse
            String host = "jdbc:mysql://localhost/DoyleHall";	//host address
            String username = "root";	//username - local host
            String password = "GroupB171110";	//password


            Connection connection = DriverManager.getConnection(host, username, password);
            System.out.println("Database covh cehjnnected!\n");

            //SQL query
            Statement stmt = connection.createStatement();
            //Current table -- faculty
            String query = "SELECT * FROM faculty";
            ResultSet rs = stmt.executeQuery(query);


            //Reads all info from table made in query
            while (rs.next()) {

                String last_name = rs.getString("Name");
                String room = rs.getString("Room_Num");
                String floor = rs.getString("Room_Floor");
                String status = rs.getString("Room_Status");
                System.out.println(last_name + " " + room + " " + status);
                int r = Integer.parseInt(room);
                int f = Integer.parseInt(floor);
                //map.setConnection(last_name, r + 1, status, f);
            }



        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
