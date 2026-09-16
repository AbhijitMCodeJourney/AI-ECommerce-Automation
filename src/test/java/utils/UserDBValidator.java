package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDBValidator {

    public static boolean isUserActive(String username) {

        DBUtil.connect();

        try {
            Statement statement = DBUtil.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT status FROM users WHERE username = '" + username + "'"
            );

            if (resultSet.next()) {
                String status = resultSet.getString("status");

                resultSet.close();
                statement.close();

                return "ACTIVE".equalsIgnoreCase(status);
            }

            resultSet.close();
            statement.close();

            return false;

        } catch (SQLException e) {
            throw new RuntimeException("User database validation failed.", e);

        } finally {
            DBUtil.closeConnection();
        }
    }
}