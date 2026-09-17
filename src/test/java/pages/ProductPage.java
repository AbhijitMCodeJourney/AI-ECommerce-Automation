
        package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By backpackAddButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private By bikeLightAddButton =
            By.id("add-to-cart-sauce-labs-bike-light");

    private By cartBadge =
            By.className("shopping_cart_badge");

    private By cartButton =
            By.className("shopping_cart_link");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void addBackpackToCart() {

        WebElement backpack =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                backpackAddButton
                        )
                );

        backpack.click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cartBadge
                )
        );
    }

    public void addBikeLightToCart() {

        WebElement bikeLight =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                bikeLightAddButton
                        )
                );

        bikeLight.click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cartBadge
                )
        );
    }

    public String getCartItemCount() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cartBadge
                )
        ).getText();
    }

    public void clickCart() {

        WebElement cart =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                cartButton
                        )
                );

        cart.click();
    }
}

