package extentReports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentReportManager.getInstance();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
        extent.flush();
    }

    public static synchronized void makeTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
    }
}
