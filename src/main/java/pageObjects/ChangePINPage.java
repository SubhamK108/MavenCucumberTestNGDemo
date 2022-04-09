package pageObjects;

import org.openqa.selenium.*;

import java.util.*;

public class ChangePINPage {
    private final WebDriver webDriver;

    public ChangePINPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public By getChangePINPageTitleLocator() {
        return By.xpath("//div[@id='change-pin']/div[1]/h3[@class='pb-vert-tab-title']");
    }

    public WebElement getChangePINButton() {
        return webDriver.findElement(By.xpath("//a[@class='nav-link pb-my-cards-icon' and @aria-controls='change-pin']"));
    }

    public List<WebElement> getPINFields() {
        return webDriver.findElements(By.xpath("//input[@type='password']"));
    }

    public List<WebElement> getPINValidators() {
        return webDriver.findElements(By.xpath("//small[contains(@data-bv-for, '_pin')]"));
    }

    public WebElement getChangeSubmitButton() {
        return webDriver.findElement(By.xpath("//button[text()='Change' and @type='submit']"));
    }

    public WebElement getResponseElement() {
        return webDriver.findElement(By.xpath("//div[@id='modal-header']"));
    }
}
