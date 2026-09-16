package tests;

import org.testng.annotations.Test;
import utils.DBUtil;

public class DatabaseConnectionTest {

    @Test
    public void verifyDatabaseConnection() {

        DBUtil.connect();

        System.out.println("Database connection test passed.");

        DBUtil.closeConnection();
    }
}