package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static Connection connection;

    public static void connect() {

        try {
            String url = "jdbc:mysql://localhost:3306/ecommerce_db";
            String username = "root";
            String password = "root";

            connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Database connected successfully.");

        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed.", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {

        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Unable to close database connection.", e);
        }
    }
}