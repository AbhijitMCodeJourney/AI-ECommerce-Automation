package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.DriverFactory;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutTest() {

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage =
                new HomePage(DriverFactory.getDriver());

        Assert.assertEquals(
                homePage.getPageTitle(),
                "Products"
        );

        ProductPage productPage =
                new ProductPage(DriverFactory.getDriver());

        productPage.addBackpackToCart();
        productPage.addBikeLightToCart();

        productPage.clickCart();

        CartPage cartPage =
                new CartPage(DriverFactory.getDriver());

        Assert.assertTrue(
                cartPage.isBackpackDisplayed()
        );

        Assert.assertTrue(
                cartPage.isBikeLightDisplayed()
        );

        cartPage.clickCheckout();

        CheckoutPage checkoutPage =
                new CheckoutPage(DriverFactory.getDriver());

        checkoutPage.enterCustomerDetails(
                "Abhijit",
                "Mali",
                "413001"
        );

        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getOrderConfirmationMessage(),
                "Thank you for your order!"
        );
    }
}