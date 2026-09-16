package listeners;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = ExtentReportManager
                .getReportInstance()
                .createTest(result.getMethod().getMethodName());

        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        long duration = result.getEndMillis() - result.getStartMillis();

        extentTest.get().pass(
                "Test Passed | Execution Time: " + duration + " ms"
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        long duration = result.getEndMillis() - result.getStartMillis();

        String screenshotPath = ScreenshotUtil.captureScreenshot(testName);

        extentTest.get().fail(result.getThrowable());

        extentTest.get().info(
                "Execution Time: " + duration + " ms"
        );

        extentTest.get().addScreenCaptureFromPath(screenshotPath);

        System.out.println("Screenshot captured for failed test: " + testName);
    }
    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().skip("Test Skipped");
    }
}