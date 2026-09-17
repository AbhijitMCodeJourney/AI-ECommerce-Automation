package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By pageTitle = By.className("title");
    private By shoppingCart = By.className("shopping_cart_link");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getPageTitle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageTitle)
        ).getText();
    }

    public void clickShoppingCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(shoppingCart)
        ).click();
    }

    public void openMenu() {

        WebElement menu =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(menuButton)
                );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                menu
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                menu
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(logoutLink)
        );
    }

    public void clickLogout() {

        WebElement logout =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(logoutLink)
                );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                logout
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                logout
        );

        wait.until(
                ExpectedConditions.urlContains("saucedemo.com")
        );
    }
}