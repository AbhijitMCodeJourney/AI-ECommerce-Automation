package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getReportInstance() {

        if (extentReports == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            sparkReporter.config().setDocumentTitle("AI E-Commerce Automation Report");
            sparkReporter.config().setReportName("Automation Test Execution Report");

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo(
                    "Project",
                    "AI-Powered E-Commerce Test Automation"
            );

            extentReports.setSystemInfo(
                    "Framework",
                    "Selenium + TestNG + POM"
            );

            extentReports.setSystemInfo(
                    "Language",
                    "Java 17"
            );

            extentReports.setSystemInfo(
                    "Browser",
                    ConfigReader.getProperty("browser")
            );

            extentReports.setSystemInfo(
                    "Environment",
                    "QA"
            );

            extentReports.setSystemInfo(
                    "Application",
                    "SauceDemo"
            );
        }

        return extentReports;
    }
    }
