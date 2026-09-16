package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.DriverFactory;

public class CartTest extends BaseTest {

    @Test
    public void verifyCartProductsTest() {

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage =
                new HomePage(DriverFactory.getDriver());

        Assert.assertEquals(homePage.getPageTitle(), "Products");

        ProductPage productPage =
                new ProductPage(DriverFactory.getDriver());

        productPage.addBackpackToCart();
        productPage.addBikeLightToCart();

        productPage.clickCart();

        CartPage cartPage =
                new CartPage(DriverFactory.getDriver());

        Assert.assertTrue(cartPage.isBackpackDisplayed());
        Assert.assertTrue(cartPage.isBikeLightDisplayed());
    }
}