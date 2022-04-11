package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.*;
import java.util.*;

public class BaseWebDriver {
    private static final ThreadLocal<String> currentScenario = new ThreadLocal<>();
    public WebDriver webDriver;
    private Properties properties;

    public static synchronized void setCurrentScenario(String currentScenario) {
        BaseWebDriver.currentScenario.set(currentScenario);
    }

    public static synchronized String getCurrentScenario() {
        return currentScenario.get();
    }

    public void initializeWebDriver() {
        System.setProperty("webdriver.edge.driver", "C:\\My_Files\\Dev\\Java\\Selenium\\WebDrivers\\edgedriver_win64\\msedgedriver.exe");
        EdgeOptions edgeDriverOptions = new EdgeOptions();
        edgeDriverOptions.addArguments("start-maximized");
        webDriver = new EdgeDriver(edgeDriverOptions);

        try {
            properties = new Properties();
            final String fileSeparator = System.getProperty("file.separator");
            final String folderPath = System.getProperty("user.dir") + fileSeparator + "Resources";
            final String fileName = "data.properties";
            final String filePath = folderPath + fileSeparator + fileName;
            File file = new File(filePath);
            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println("Properties file not found!");
        }
    }

    public void closeAllBrowserWindows() {
        webDriver.quit();
    }

    public void navigateToLink() {
        final String URL = properties.getProperty("URL");
        webDriver.get(URL);
    }
}
