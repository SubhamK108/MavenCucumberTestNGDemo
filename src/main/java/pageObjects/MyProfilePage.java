package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;

public class MyProfilePage {
    private final WebDriver webDriver;

    public MyProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public By getMyProfilePageTitleLocator() {
        return By.xpath("//div[@class='myprofile']/div[1]/h3[@class='pb-vert-tab-title']");
    }

    public WebElement getMyProfileButton() {
        return webDriver.findElement(By.xpath("//a[@class='nav-link pb-my-cards-icon' and @aria-controls='my-profile']"));
    }

    public WebElement getProfileNameElement() {
        return webDriver.findElement(By.xpath("//span[@class='pb-user-name']"));
    }

    public WebElement getFirstNameField() {
        return webDriver.findElement(By.xpath("//input[@name='user_first_name']"));
    }

    public WebElement getPINCodeField() {
        return webDriver.findElement(By.xpath("//input[@name='postcode']"));
    }

    public List<WebElement> getPINCodeValidators() {
        return webDriver.findElements(By.xpath("//small[@data-bv-for='postcode']"));
    }

    public Select getStateDropdown() {
        return new Select(webDriver.findElement(By.xpath("//select[@name='state']")));
    }

    public Select getCityDropdown() {
        return new Select(webDriver.findElement(By.xpath("//select[@name='city']")));
    }

    public WebElement getOtherDetailsExpander() {
        return webDriver.findElement(By.xpath("//div[@class='pb-accordion-comp']/h3"));
    }

    public Select getGenderDropdown() {
        return new Select(webDriver.findElements(By.xpath("//select[@name='spouseGender']")).get(0));
    }

    public Select getMaritalStatusDropdown() {
        return new Select(webDriver.findElement(By.xpath("//select[@name='marital_status']")));
    }

    public WebElement getAddressField() {
        return webDriver.findElement(By.xpath("//input[@name='address1']"));
    }

    public WebElement getSaveButton() {
        return webDriver.findElement(By.xpath("//button[text()='Save Changes']"));
    }

    public WebElement getResponseElement() {
        return webDriver.findElement(By.xpath("//div[@id='modal-header']"));
    }
}
