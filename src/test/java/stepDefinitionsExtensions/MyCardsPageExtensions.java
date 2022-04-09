package stepDefinitionsExtensions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pageObjects.*;

import java.time.*;

public class MyCardsPageExtensions {
    private final WebDriver webDriver;

    public MyCardsPageExtensions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean navigateToMyCardsPage() {
        MyCardsPage myCardsPage = new MyCardsPage(webDriver);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error!");
        }
        myCardsPage.getMyCardsButton().click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(myCardsPage.getMyCardsPageTitleLocator()));
        return true;
    }

    public boolean isInsideMyCardsPage() {
        MyCardsPage myCardsPage = new MyCardsPage(webDriver);
        By pageTitleLocator = myCardsPage.getMyCardsPageTitleLocator();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleLocator));
        return webDriver.findElement(pageTitleLocator).getText().equalsIgnoreCase("my cards");
    }

    public boolean isCardOwnerAndNumberPresent() {
        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        MyCardsPage myCardsPage = new MyCardsPage(webDriver);
        String profileName = myProfilePage.getProfileNameElement().getText().toLowerCase();
        String cardOwnerName = myCardsPage.getCardOwnerNameElement().getText().toLowerCase();
        String cardNumber = myCardsPage.getCardNumberElement().getText();
        return profileName.contains(cardOwnerName) && cardNumber.length() == 16;
    }

    public boolean clickMyTransactionsButton() {
        MyCardsPage myCardsPage = new MyCardsPage(webDriver);
        MyTransactionsPage myTransPage = new MyTransactionsPage(webDriver);
        myCardsPage.getMyTransactionsButton().click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(myTransPage.getMyTransactionsPageTitleLocator()));
        return true;
    }
}
