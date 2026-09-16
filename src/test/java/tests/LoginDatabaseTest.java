package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.UserDBValidator;

public class LoginDatabaseTest extends BaseTest {

    @Test
    public void verifyLoginAndDatabaseUser() {

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        HomePage homePage =
                new HomePage(DriverFactory.getDriver());

        Assert.assertEquals(
                homePage.getPageTitle(),
                "Products"
        );

        boolean userActive =
                UserDBValidator.isUserActive(
                        ConfigReader.getProperty("username")
                );

        Assert.assertTrue(
                userActive,
                "Logged-in user is not ACTIVE in database."
        );

        System.out.println(
                "UI Login and Database validation passed."
        );
    }
}