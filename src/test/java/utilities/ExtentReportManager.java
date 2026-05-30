package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports extent;
    public static ExtentTest test;

    // Create Extent Report
    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

            String reportPath = System.getProperty("user.dir")
                    + "\\reports\\ExtentReport_" + timeStamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("OpenCart Automation Report");
            sparkReporter.config().setDocumentTitle("Automation Test Results");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Application", "OpenCart");
            extent.setSystemInfo("Tester", "Madhu");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }

        return extent;
    }

    // Create Test 
    public static ExtentTest createTest(String testName) {

        test = getReportInstance().createTest(testName);

        return test;
    }

    // Pass Method
    public static void logPass(String message) {

        test.pass(message);
    }

    // Fail Method
    public static void logFail(String message) {

        test.fail(message);
    }

    // Info Method
    public static void logInfo(String message) {

        test.info(message);
    }

    // Skip Method
    public static void logSkip(String message) {

        test.skip(message);
    }

    // Add Screenshot
    public static void addScreenshot(String screenshotPath) {

        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Flush Report
    public static void flushReport() {

        extent.flush();
    }
}