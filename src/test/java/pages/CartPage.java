
        package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private By checkoutFirstName =
            By.id("first-name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean isBackpackDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        backpack
                )
        ).isDisplayed();
    }

    public boolean isBikeLightDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        bikeLight
                )
        ).isDisplayed();
    }

    public void clickCheckout() {

        WebElement checkout =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                checkoutButton
                        )
                );

        // Bring the button into the visible browser area.
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                checkout
        );

        // Wait until it is clickable.
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        checkoutButton
                )
        );

        checkout.click();

        // Verify that the checkout page actually loaded.
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        checkoutFirstName
                )
        );
    }
}