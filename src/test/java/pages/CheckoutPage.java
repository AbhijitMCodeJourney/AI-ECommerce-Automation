package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By orderConfirmation = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterFirstName(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys(value);
    }

    public void enterLastName(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName))
                .sendKeys(value);
    }

    public void enterPostalCode(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode))
                .sendKeys(value);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton))
                .click();
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));

        wait.until(ExpectedConditions.elementToBeClickable(finishButton));

        driver.findElement(finishButton).click();
    }

    public String getOrderConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmation))
                .getText();
    }

    public void enterCustomerDetails(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }
}