package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.DriverFactory;

public class ProductTest extends BaseTest {

    @Test
    public void addMultipleProductsToCartTest() {

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage =
                new HomePage(DriverFactory.getDriver());

        Assert.assertEquals(homePage.getPageTitle(), "Products");

        ProductPage productPage =
                new ProductPage(DriverFactory.getDriver());

        productPage.addBackpackToCart();
        productPage.addBikeLightToCart();

        Assert.assertEquals(productPage.getCartItemCount(), "2");
    }
}