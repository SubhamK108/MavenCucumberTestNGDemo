package testOptions;

import com.aventstack.extentreports.*;
import extentReports.*;
import org.testng.*;
import utils.*;

public class TestngListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = BaseWebDriver.getCurrentScenario();
        ExtentTestManager.makeTest(testName);
        System.out.println("SCENARIO PASSED :D");
        ExtentTestManager.getTest().log(Status.INFO, "Scenario Name: " + testName);
        ExtentTestManager.getTest().log(Status.PASS, "Scenario Passed");
        try {
            String ssPath = ScreenshotUtil.getLastScreenshotFilename();
            ExtentTestManager.getTest().log(
                    Status.PASS,
                    "Screenshot of the passed scenario",
                    MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build()
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error while taking/saving screenshot!");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = BaseWebDriver.getCurrentScenario();
        ExtentTestManager.makeTest(testName);
        System.out.println("SCENARIO FAILED :(");
        ExtentTestManager.getTest().log(Status.INFO, "Scenario Name: " + testName);
        ExtentTestManager.getTest().log(Status.FAIL, "Scenario Failed");
        ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
        try {
            String ssPath = ScreenshotUtil.getLastScreenshotFilename();
            ExtentTestManager.getTest().log(
                    Status.FAIL,
                    "Screenshot of the failed scenario",
                    MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build()
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error while taking/saving screenshot!");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = BaseWebDriver.getCurrentScenario();
        ExtentTestManager.makeTest(testName);
        System.out.println("SCENARIO SKIPPED :|");
        ExtentTestManager.getTest().log(Status.INFO, "Scenario Name: " + testName);
        ExtentTestManager.getTest().log(Status.SKIP, "Scenario Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.endTest();
        ExtentReportManager.getInstance().flush();
    }
}
