package stepDefinitionsExtensions;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pageObjects.*;
import utils.*;

import java.time.*;
import java.util.*;

public class ChangePINPageExtensions {
    private final WebDriver webDriver;

    public ChangePINPageExtensions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean navigateToChangePINPage() {
        ChangePINPage changePINPage = new ChangePINPage(webDriver);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error!");
        }
        changePINPage.getChangePINButton().click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(changePINPage.getChangePINPageTitleLocator()));
        return true;
    }

    public boolean isInsideChangePINPage() {
        ChangePINPage changePINPage = new ChangePINPage(webDriver);
        By pageTitleLocator = changePINPage.getChangePINPageTitleLocator();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleLocator));
        return webDriver.findElement(pageTitleLocator).getText().equalsIgnoreCase("change pin");
    }

    public boolean enterInvalidPINs(String sheetName, int rowIndex) {
        ExcelReader excelReader = new ExcelReader();
        Row row = excelReader.getRowBySheetAndIndex(sheetName, rowIndex);
        String oldPIN = excelReader.getCellData(row, 0);
        String newPIN = excelReader.getCellData(row, 1);
        String confirmPIN = excelReader.getCellData(row, 2);

        ChangePINPage changePINPage = new ChangePINPage(webDriver);
        List<WebElement> pinFields = changePINPage.getPINFields();
        pinFields.get(0).sendKeys(oldPIN, Keys.TAB);
        pinFields.get(1).sendKeys(newPIN, Keys.TAB);
        pinFields.get(2).sendKeys(confirmPIN, Keys.TAB);
        for (WebElement elem : changePINPage.getPINValidators()) {
            if (elem.getAttribute("data-bv-result").equals("INVALID"))
                return true;
        }
        return oldPIN.length() != 4 || newPIN.length() != 4 || confirmPIN.length() != 4;
    }

    public boolean enterValidPINs(String sheetName, int rowIndex) {
        ExcelReader excelReader = new ExcelReader();
        Row row = excelReader.getRowBySheetAndIndex(sheetName, rowIndex);
        String oldPIN = excelReader.getCellData(row, 0);
        String newPIN = excelReader.getCellData(row, 1);
        String confirmPIN = excelReader.getCellData(row, 2);

        ChangePINPage changePINPage = new ChangePINPage(webDriver);
        List<WebElement> pinFields = changePINPage.getPINFields();
        pinFields.get(0).sendKeys(oldPIN, Keys.TAB);
        pinFields.get(1).sendKeys(newPIN, Keys.TAB);
        pinFields.get(2).sendKeys(confirmPIN, Keys.TAB);
        for (WebElement elem : changePINPage.getPINValidators()) {
            if (elem.getAttribute("data-bv-result").equals("INVALID"))
                return false;
        }
        return oldPIN.length() == 4 && newPIN.length() == 4 && confirmPIN.length() == 4;
    }

    public boolean clickChangeButtonWhenInvalid() {
        ChangePINPage changePINPage = new ChangePINPage(webDriver);
        WebElement changeButton = changePINPage.getChangeSubmitButton();
        changeButton.click();
        return changeButton.getAttribute("disabled").equals("true");
    }

    public boolean clickChangeButtonWhenValid() {
        ChangePINPage changePINPage = new ChangePINPage(webDriver);
        changePINPage.getChangeSubmitButton().click();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error!");
        }
        String responseText = changePINPage.getResponseElement().getText();
        return responseText.equalsIgnoreCase("success");
    }
}
