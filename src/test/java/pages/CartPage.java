package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By backpack =
            By.id("item_4_title_link");

    private By bikeLight =
            By.id("item_0_title_link");

    private By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isBackpackDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(backpack)
        ).isDisplayed();
    }

    public boolean isBikeLightDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(bikeLight)
        ).isDisplayed();
    }

    public void clickCheckout() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(checkoutButton)
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(checkoutButton)
        );

        driver.findElement(checkoutButton).click();
    }
}