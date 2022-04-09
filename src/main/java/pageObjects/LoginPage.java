package pageObjects;

import org.openqa.selenium.*;

public class LoginPage {
    private final WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement getLoginNumberField() {
        return webDriver.findElement(By.xpath("//input[@name='card_number']"));
    }

    public WebElement getLoginPINField() {
        return webDriver.findElement(By.xpath("//input[@name='pin_number']"));
    }

    public WebElement getLoginButton() {
        return webDriver.findElement(By.xpath("//button[@class='btn pb-login-submit red-button']"));
    }

    public WebElement getProfileHoverElement() {
        return webDriver.findElement(By.xpath("//span[@class='pb-user-name']"));
    }
}
