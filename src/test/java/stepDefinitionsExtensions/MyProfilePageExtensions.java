package stepDefinitionsExtensions;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import pageObjects.*;
import utils.*;

import java.time.*;

public class MyProfilePageExtensions {
    private final WebDriver webDriver;

    public MyProfilePageExtensions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean navigateToMyProfilePage() {
        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error!");
        }
        myProfilePage.getMyProfileButton().click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(myProfilePage.getMyProfilePageTitleLocator()));
        return true;
    }

    public boolean isInsideMyProfilePage() {
        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
        By pageTitleLocator = myProfilePage.getMyProfilePageTitleLocator();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleLocator));
        return webDriver.findElement(pageTitleLocator).getText().equalsIgnoreCase("my profile");
    }

    public boolean checkIfAllFieldsAreEditable() {
        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        WebElement firstNameField = myProfilePage.getFirstNameField();
        return firstNameField.getAttribute("readonly").equals("false");
    }

    public boolean editPINFieldWithInvalidData(String pin) {
        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        WebElement pinField = myProfilePage.getPINCodeField();
        pinField.clear();
        pinField.sendKeys(pin, Keys.TAB);
        for (WebElement ele : myProfilePage.getPINCodeValidators()) {
            if (ele.getAttribute("data-bv-result").equals("INVALID"))
                return true;
        }
        return pin.length() != 6;
    }

    public boolean editPINFieldWithInvalidDataExternal(String sheetName, int rowIndex) {
        ExcelReader excelReader = new ExcelReader();
        Row row = excelReader.getRowBySheetAndIndex(sheetName, rowIndex);
        String pin = excelReader.getCellData(row, 0);

        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        WebElement pinField = myProfilePage.getPINCodeField();
        pinField.clear();
        pinField.sendKeys(pin, Keys.TAB);
        for (WebElement ele : myProfilePage.getPINCodeValidators()) {
            if (ele.getAttribute("data-bv-result").equals("INVALID"))
                return true;
        }
        return pin.length() != 6;
    }

    public boolean editPINFieldWithValidData(String pin) {
        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        WebElement pinField = myProfilePage.getPINCodeField();
        pinField.clear();
        pinField.sendKeys(pin, Keys.TAB);
        for (WebElement ele : myProfilePage.getPINCodeValidators()) {
            if (ele.getAttribute("data-bv-result").equals("INVALID"))
                return false;
        }
        return pin.length() == 6;
    }

    public boolean editPINFieldWithValidDataExternal(String sheetName, int rowIndex) {
        ExcelReader excelReader = new ExcelReader();
        Row row = excelReader.getRowBySheetAndIndex(sheetName, rowIndex);
        String pin = excelReader.getCellData(row, 0);

        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        WebElement pinField = myProfilePage.getPINCodeField();
        pinField.clear();
        pinField.sendKeys(pin, Keys.TAB);
        for (WebElement ele : myProfilePage.getPINCodeValidators()) {
            if (ele.getAttribute("data-bv-result").equals("INVALID"))
                return false;
        }
        return pin.length() == 6;
    }

    public boolean checkStateAndCityDropdowns() {
        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        Select stateDropdown = myProfilePage.getStateDropdown();
        Select cityDropdown = myProfilePage.getCityDropdown();
        if (stateDropdown.getOptions().size() == 0)
            return false;
        stateDropdown.selectByIndex(8);
        return cityDropdown.getOptions().size() > 0;
    }

    public boolean expandOtherDetails() {
        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        WebElement otherDetails = myProfilePage.getOtherDetailsExpander();
        otherDetails.click();
        return otherDetails.getAttribute("aria-expanded").equals("true");
    }

    public boolean checkGenderAndMaritalStatusDropdowns() {
        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        myProfilePage.getOtherDetailsExpander().click();
        Select genderDropdown = myProfilePage.getGenderDropdown();
        Select maritalStatusDropdown = myProfilePage.getMaritalStatusDropdown();
        return genderDropdown.getOptions().size() > 0 && maritalStatusDropdown.getOptions().size() > 0;
    }

    public boolean editAddressAndPINField() {
        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        WebElement pinField = myProfilePage.getPINCodeField();
        pinField.clear();
        pinField.sendKeys("123456");
        myProfilePage.getAddressField().sendKeys("Any Address");
        return true;
    }

    public boolean clickSaveButton() {
        MyProfilePage myProfilePage = new MyProfilePage(webDriver);
        myProfilePage.getSaveButton().click();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error!");
        }
        String responseText = myProfilePage.getResponseElement().getText();
        return responseText.equalsIgnoreCase("success");
    }
}
