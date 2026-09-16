package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UserDBValidator;

public class DatabaseTest {

    @Test
    public void verifyUserData() {

        boolean userActive =
                UserDBValidator.isUserActive("standard_user");

        Assert.assertTrue(
                userActive,
                "User is not ACTIVE in database."
        );

        System.out.println(
                "User database validation passed."
        );
    }
}