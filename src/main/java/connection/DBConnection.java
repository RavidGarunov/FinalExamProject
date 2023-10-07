package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {


    private static Connection connection = null;


    public static Connection getConnection () {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
           connection= DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "password");
            System.out.println("Connected successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void connectionClose (Connection connection) {

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
