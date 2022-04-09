package stepDefinitionsExtensions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import pageObjects.*;

import java.time.*;
import java.util.*;

public class MyTransactionsPageExtension {
    private final WebDriver webDriver;

    public MyTransactionsPageExtension(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean navigateToMyTransactionsPage() {
        MyTransactionsPage myTransPage = new MyTransactionsPage(webDriver);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error!");
        }
        myTransPage.getMyTransactionsButton().click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(myTransPage.getMyTransactionsPageTitleLocator()));
        return true;
    }

    public boolean isInsideMyTransactionsPage() {
        MyTransactionsPage myTransPage = new MyTransactionsPage(webDriver);
        By pageTitleLocator = myTransPage.getMyTransactionsPageTitleLocator();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleLocator));
        return webDriver.findElement(pageTitleLocator).getText().equalsIgnoreCase("transaction details");
    }

    public boolean clickRedeemButtons() {
        MyTransactionsPage myTransPage = new MyTransactionsPage(webDriver);
        Actions actions = new Actions(webDriver);
        Action action = actions
                .keyDown(Keys.CONTROL)
                .click(myTransPage.getRedeemCatalogueButton())
                .keyUp(Keys.CONTROL)
                .build();
        action.perform();
        Set<String> windows = webDriver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        webDriver.switchTo().window(childWindow);
        String expectedTitle = "Redeem PAYBACK Points, Rewards Program - Rewards Catalogue";
        if (!webDriver.getTitle().contains(expectedTitle))
            return false;

        webDriver.close();
        webDriver.switchTo().window(parentWindow);
        action = actions
                .keyDown(Keys.CONTROL)
                .click(myTransPage.getRedeemVouchersButton())
                .keyUp(Keys.CONTROL)
                .build();
        action.perform();
        windows = webDriver.getWindowHandles();
        itr = windows.iterator();
        parentWindow = itr.next();
        childWindow = itr.next();
        webDriver.switchTo().window(childWindow);
        expectedTitle = "Redeem Payback Points for Instant Free Gift cards | PAYBACK Voucher World";
        if (!webDriver.getTitle().contains(expectedTitle))
            return false;

        webDriver.close();
        webDriver.switchTo().window(parentWindow);
        return true;
    }

    public boolean clickTableButtons() {
        MyTransactionsPage myTransPage = new MyTransactionsPage(webDriver);
        for (WebElement element : myTransPage.getTableButtons()) {
            if (element.getAttribute("disabled").equals("false"))
                return false;
        }
        return true;
    }

    public boolean clickTableFilters() {
        MyTransactionsPage myTransPage = new MyTransactionsPage(webDriver);
        for (WebElement element : myTransPage.getTableFilters()) {
            if (element.getAttribute("readonly").equals("false"))
                return false;
        }
        return true;
    }

    public boolean isEmptyTableTextDisplayed(String text) {
        MyTransactionsPage myTransPage = new MyTransactionsPage(webDriver);
        return myTransPage.getEmptyTableText().getText().equalsIgnoreCase(text);
    }
}
