package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverFactory;
import org.testng.annotations.AfterSuite;
import utils.ExtentReportManager;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initializeDriver();
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
    @AfterSuite
    public void generateReport() {
        ExtentReportManager.getReportInstance().flush();
    }
}