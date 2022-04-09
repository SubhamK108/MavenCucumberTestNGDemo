package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

import static org.testng.Assert.*;

import stepDefinitionsExtensions.*;
import utils.*;

public class StepDefinitions extends BaseWebDriver {
    @Before
    public void initializeWebDriver(Scenario currentScenario) {
        setCurrentScenario(currentScenario.getName());
        super.initializeWebDriver();
    }

    @After
    public void closeAllBrowserWindows() {
        String ssPath = ScreenshotUtil.takeScreenshot(webDriver);
        ScreenshotUtil.setLastScreenshotFilename(ssPath);
        super.closeAllBrowserWindows();
    }

    @And("The user navigates to the link")
    public void theUserNavigatesToLink() {
        navigateToLink();
    }

    @And("The user is logged in using valid credentials")
    public void theUserIsLoggedInUsingValidCredentials() {
        LoginPageExtensions loginPageExt = new LoginPageExtensions(webDriver);
        assertTrue(loginPageExt.login());
    }

    @When("The user is in the MyProfile page")
    public void theUserIsInTheMyProfilePage() {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.isInsideMyProfilePage());
    }

    @And("The user navigates to the MyProfile page")
    public void theUserNavigatesToTheMyProfilePage() {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.navigateToMyProfilePage());
    }

    @Then("Check if all the fields are editable")
    public void checkIfAllTheFieldsAreEditable() {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.checkIfAllFieldsAreEditable());
        // BUG
    }

    @Then("Edit the PIN CODE field with invalid {string}")
    public void editThePINCODEFieldWithInvalidValues(String pin) {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.editPINFieldWithInvalidData(pin));
    }

    @Then("Edit the PIN CODE field with invalid data from {string} sheet and row {int}")
    public void editThePINCODEFieldWithInvalidDataFromSheetAndRow(String sheetName, int rowIndex) {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.editPINFieldWithInvalidDataExternal(sheetName, rowIndex));
    }

    @Then("Edit the PIN CODE field with valid {string}")
    public void editThePINCODEFieldWithValid(String pin) {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.editPINFieldWithValidData(pin));
    }

    @Then("Edit the PIN CODE field with valid data from {string} sheet and row {int}")
    public void editThePINCODEFieldWithValidDataFromSheetAndRowRowNumber(String sheetName, int rowIndex) {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.editPINFieldWithValidDataExternal(sheetName, rowIndex));
    }

    @Then("Open the drop-down lists of STATE and CITY fields and check for values")
    public void openTheDropDownListsOfSTATEAndCITYFieldsAndCheckForValues() {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.checkStateAndCityDropdowns());
    }

    @Then("Click on the OTHER DETAILS section or text")
    public void clickOnTheOTHERDETAILSSectionOrText() {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.expandOtherDetails());
    }

    @Then("Open the drop-down lists of GENDER and MARITAL STATUS fields and check for values")
    public void openTheDropDownListsOfGENDERAndMARITALSTATUSFieldsAndCheckForValues() {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.checkGenderAndMaritalStatusDropdowns());
    }

    @Then("Edit the ADDRESS and PIN field with any valid data")
    public void editTheADDRESSAndPINFieldWithAnyValidData() {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.editAddressAndPINField());
    }

    @And("Click on the Save Changes button")
    public void clickOnTheSaveChangesButton() {
        MyProfilePageExtensions myProfilePageExt = new MyProfilePageExtensions(webDriver);
        assertTrue(myProfilePageExt.clickSaveButton());
        // BUG
    }

    @When("The user is in the MyCards page")
    public void theUserIsInTheMyCardsPage() {
        MyCardsPageExtensions myCardsPageExt = new MyCardsPageExtensions(webDriver);
        assertTrue(myCardsPageExt.isInsideMyCardsPage());
    }

    @And("The user navigates to the MyCards page")
    public void theUserNavigatesToTheMyCardsPage() {
        MyCardsPageExtensions myCardsPageExt = new MyCardsPageExtensions(webDriver);
        assertTrue(myCardsPageExt.navigateToMyCardsPage());
    }

    @Then("A card is visible with the name of the user and a card number")
    public void aCardIsVisibleWithTheNameOfTheUserAndACardNumber() {
        MyCardsPageExtensions myCardsPageExt = new MyCardsPageExtensions(webDriver);
        assertTrue(myCardsPageExt.isCardOwnerAndNumberPresent());
    }

    @Then("Click on the View Transactions button")
    public void clickOnTheViewTransactionsButton() {
        MyCardsPageExtensions myCardsPageExt = new MyCardsPageExtensions(webDriver);
        assertTrue(myCardsPageExt.clickMyTransactionsButton());
    }

    @And("The user navigates to the MyPoints page")
    public void theUserNavigatesToTheMyPointsPage() {
        MyTransactionsPageExtension myTransPageExt = new MyTransactionsPageExtension(webDriver);
        assertTrue(myTransPageExt.navigateToMyTransactionsPage());
    }

    @When("The user is in the MyPoints page")
    public void theUserIsInTheMyPointsPage() {
        MyTransactionsPageExtension myTransPageExt = new MyTransactionsPageExtension(webDriver);
        assertTrue(myTransPageExt.isInsideMyTransactionsPage());
    }

    @Then("Click on the Redeem-Catalogue and Redeem-Vouchers buttons")
    public void clickOnTheRedeemCatalogueAndRedeemVouchersButtons() {
        MyTransactionsPageExtension myTransPageExt = new MyTransactionsPageExtension(webDriver);
        assertTrue(myTransPageExt.clickRedeemButtons());
    }

    @And("The user navigates to the MyTransactions page")
    public void theUserNavigatesToTheMyTransactionsPage() {
        MyTransactionsPageExtension myTransPageExt = new MyTransactionsPageExtension(webDriver);
        assertTrue(myTransPageExt.navigateToMyTransactionsPage());
    }

    @When("The user is in the MyTransactions page")
    public void theUserIsInTheMyTransactionsPage() {
        MyTransactionsPageExtension myTransPageExt = new MyTransactionsPageExtension(webDriver);
        assertTrue(myTransPageExt.isInsideMyTransactionsPage());
    }

    @Then("Click on the View, Download and Reset buttons")
    public void clickOnTheViewDownloadAndResetButtons() {
        MyTransactionsPageExtension myTransPageExt = new MyTransactionsPageExtension(webDriver);
        assertTrue(myTransPageExt.clickTableButtons());
    }

    @Then("Use the From and To table filters")
    public void useTheFromAndToTableFilters() {
        MyTransactionsPageExtension myTransPageExt = new MyTransactionsPageExtension(webDriver);
        assertTrue(myTransPageExt.clickTableFilters());
    }

    @Then("The past transactions table displays {string} text")
    public void thePastTransactionsTableDisplaysText(String text) {
        MyTransactionsPageExtension myTransPageExt = new MyTransactionsPageExtension(webDriver);
        assertTrue(myTransPageExt.isEmptyTableTextDisplayed(text));
    }

    @And("The user navigates to the ChangePIN page")
    public void theUserNavigatesToTheChangePINPage() {
        ChangePINPageExtensions changePINPageExt = new ChangePINPageExtensions(webDriver);
        assertTrue(changePINPageExt.navigateToChangePINPage());
    }

    @When("The user is in the ChangePIN page")
    public void theUserIsInTheChangePINPage() {
        ChangePINPageExtensions changePINPageExt = new ChangePINPageExtensions(webDriver);
        assertTrue(changePINPageExt.isInsideChangePINPage());
    }

    @And("On clicking the Change button, nothing happens")
    public void onClickingTheChangeButtonNothingHappens() {
        ChangePINPageExtensions changePINPageExt = new ChangePINPageExtensions(webDriver);
        assertTrue(changePINPageExt.clickChangeButtonWhenInvalid());
    }

    @And("On clicking the Change button, a SUCCESS message is shown and PIN is changed")
    public void onClickingTheChangeButtonASUCCESSMessageIsShownAndPINIsChanged() {
        ChangePINPageExtensions changePINPageExt = new ChangePINPageExtensions(webDriver);
        assertTrue(changePINPageExt.clickChangeButtonWhenValid());
    }

    @Then("Provide invalid data for OLD PIN, NEW PIN and CONFIRM PIN fields from {string} sheet and row {int}")
    public void provideInvalidDataForOLDPINNEWPINAndCONFIRMPINFieldsFromSheetAndRowRowNumber(String sheetName, int rowIndex) {
        ChangePINPageExtensions changePINPageExt = new ChangePINPageExtensions(webDriver);
        assertTrue(changePINPageExt.enterInvalidPINs(sheetName, rowIndex));
    }

    @Then("Provide valid data for OLD PIN, NEW PIN and CONFIRM PIN fields from {string} sheet and row {int}")
    public void provideValidDataForOLDPINNEWPINAndCONFIRMPINFieldsFromSheetAndRowRowNumber(String sheetName, int rowIndex) {
        ChangePINPageExtensions changePINPageExt = new ChangePINPageExtensions(webDriver);
        assertTrue(changePINPageExt.enterValidPINs(sheetName, rowIndex));
    }
}
