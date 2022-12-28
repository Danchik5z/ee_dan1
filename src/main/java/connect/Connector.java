package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static final String DB_USER_NAME = "postgres";
    private static final String DB_PASSWORD = "1234";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/museum_db";

    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("sakhjadskj");
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
    }
}

