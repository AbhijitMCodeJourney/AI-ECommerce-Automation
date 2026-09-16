package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage =
                new HomePage(DriverFactory.getDriver());

        Assert.assertEquals(
                homePage.getPageTitle(),
                "Products"
        );

        homePage.openMenu();

        homePage.clickLogout();

        Assert.assertTrue(
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .contains("saucedemo.com")
        );
    }
}