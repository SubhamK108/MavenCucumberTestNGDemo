package pageObjects;

import org.openqa.selenium.*;

import java.util.*;

public class MyTransactionsPage {
    private final WebDriver webDriver;

    public MyTransactionsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public By getMyTransactionsPageTitleLocator() {
        return By.xpath("//div[@class='pb-profile-transaction-comp']/h3[@class='pb-vert-tab-title']");
    }

    public WebElement getMyTransactionsButton() {
        return webDriver.findElement(By.xpath("//a[@class='nav-link pb-my-cards-icon' and @aria-controls='my-transactions']"));
    }

    public WebElement getRedeemCatalogueButton() {
        return webDriver.findElement(By.xpath("//a[text()='  Redeem-Catalogue ']"));
    }

    public WebElement getRedeemVouchersButton() {
        return webDriver.findElement(By.xpath("//a[text()=' Redeem-Vouchers ']"));
    }

    public List<WebElement> getTableButtons() {
        return webDriver.findElements(By.xpath("//div[@class='pb-profile-transaction-buttons']/button"));
    }

    public List<WebElement> getTableFilters() {
        return webDriver.findElements(By.xpath("//input[@type='text' and @class='input-md form-control']"));
    }

    public WebElement getEmptyTableText() {
        return webDriver.findElement(By.xpath("//table/tbody/tr/td"));
    }
}
