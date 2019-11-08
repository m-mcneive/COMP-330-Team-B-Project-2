package database_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMS {
    public static void main(String[] args) {

        try {

            String host;
            String username;
            String password;

            Connection connection = DriverManager.getConnection(host, username, password);

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}