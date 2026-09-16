package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.LoginDataProvider;

public class DataDrivenLoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void loginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.login(username, password);

        if (username.equals("standard_user") && password.equals("secret_sauce")) {

            HomePage homePage = new HomePage(DriverFactory.getDriver());

            Assert.assertEquals(
                    homePage.getPageTitle(),
                    "Products"
            );

        } else {

            String errorMessage = loginPage.getErrorMessage();

            Assert.assertTrue(
                    errorMessage.contains("Username and password do not match")
            );
        }
    }
}