package stepDefinitionsExtensions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import pageObjects.*;

import java.time.*;

public class LoginPageExtensions {
    private final WebDriver webDriver;

    public LoginPageExtensions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean login() {
        LoginPage loginPage = new LoginPage(webDriver);
        Actions actions = new Actions(webDriver);
        final String PHONE_NUMBER = "6290359434";
        final String PIN = "1209";
        Action action = actions
                .click(loginPage.getLoginNumberField())
                .sendKeys(PHONE_NUMBER)
                .click(loginPage.getLoginPINField())
                .sendKeys(PIN)
                .build();
        action.perform();
        WebElement loginButton = loginPage.getLoginButton();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='myprofile']/div[1]/h3[@class='pb-vert-tab-title']")));
        return true;
    }
}
