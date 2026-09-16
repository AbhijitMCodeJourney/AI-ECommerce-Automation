package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(
                "invalid_user",
                "wrong_password"
        );

        String errorMessage =
                loginPage.getErrorMessage();

        Assert.assertTrue(
                errorMessage.contains(
                        "Username and password do not match"
                )
        );
    }
}
