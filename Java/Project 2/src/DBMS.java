import java.io.IOException;
import java.sql.*;

//import java.util.concurrent.TimeUnit;

public class DBMS {
    public static void main(String[] args) throws IOException {
        Map map = new Map(19);
        FloorLayout fl = new FloorLayout();
        System.out.println("Starting");
        try {

            //Connection info for databse
            String host = "jdbc:mysql://localhost/DoyleHall";    //host address
            String username = "root";    //username - local host
            String password = "GroupB171110";    //password


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
                String room = rs.getString("Room_Num");
                String floor = rs.getString("Room_Floor");
                String status = rs.getString("Room_Status");
                System.out.println(last_name + " " + floor + "-" + room + " " + status);
                int r = Integer.parseInt(room);
                int f = Integer.parseInt(floor);
                if (f == 3) {
                	f  = 1;
                } else {
                	f = 0;
                }
                map.setConnection(last_name, r, status, f + 2);
            }

            Floor f2 = map.getFloor(2);
            Floor f3 = map.getFloor(3);

           

            /*for (int i = 1; i < f2.rooms.length; i++) {
                fl.editFloorPlan(f2.rooms[i - 1], f2);
            }*/

            fl.readFloorPlan(3);
            for (int i = 1; i < f3.rooms.length - 1; i++) {
                fl.editFloorPlan(f3.rooms[i], f3);
            }
            
			
            fl.saveImage(3);
            fl.displayFinalMap(3);


        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
