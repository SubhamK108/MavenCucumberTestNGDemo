package pageObjects;

import org.openqa.selenium.*;

public class MyCardsPage {
    private final WebDriver webDriver;

    public MyCardsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public By getMyCardsPageTitleLocator() {
        return By.xpath("//div[@id='my-cards']/div[1]/h3[@class='pb-vert-tab-title']");
    }

    public WebElement getMyCardsButton() {
        return webDriver.findElement(By.xpath("//a[@class='nav-link pb-my-cards-icon' and @aria-controls='my-cards']"));
    }

    public WebElement getCardOwnerNameElement() {
        return webDriver.findElement(By.xpath("//div[@class='pb-card-owner-name']"));
    }

    public WebElement getCardNumberElement() {
        return webDriver.findElement(By.xpath("//div[@class='pb-card-owner-number']"));
    }

    public WebElement getMyTransactionsButton() {
        return webDriver.findElement(By.xpath("//a[text()='View Transactions']"));
    }
}
