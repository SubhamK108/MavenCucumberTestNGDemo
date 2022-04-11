Feature: Functionalities in the MyProfile page.

  Background:
    Given The user navigates to the link
    And The user is logged in using valid credentials
    And The user navigates to the MyProfile page

  @Bug @HighPriority
  Scenario: All the fields in the MyProfile page are editable.
    When The user is in the MyProfile page
    Then Check if all the fields are editable

  @HighPriority
  Scenario Outline: The PIN CODE field does not accept any input other than 6-digit numbers.
    When The user is in the MyProfile page
    Then Edit the PIN CODE field with invalid data from "Invalid_PIN_Data" sheet and row <rowNumber>
    Examples:
      | rowNumber |
      | 1         |
      | 2         |
      | 3         |

  @HighPriority
  Scenario Outline: The PIN CODE field accepts any 6-digit number as input.
    When The user is in the MyProfile page
    Then Edit the PIN CODE field with valid data from "Valid_PIN_Data" sheet and row <rowNumber>
    Examples:
      | rowNumber |
      | 1         |
      | 2         |
      | 3         |

  @HighPriority @TestA
  Scenario: The drop-down lists for STATE and CITY selections displays all the available options.
    When The user is in the MyProfile page
    Then Open the drop-down lists of STATE and CITY fields and check for values

  @LowPriority @Test
  Scenario: The OTHER DETAILS section/text is clickable and on-click it displays additional fields.
    When The user is in the MyProfile page
    Then Click on the OTHER DETAILS section or text

  @LowPriority @Test
  Scenario: The drop down list for GENDER and MARITAL STATUS selections display all the available options.
    When The user is in the MyProfile page
    Then Open the drop-down lists of GENDER and MARITAL STATUS fields and check for values

  @Bug @HighPriority
  Scenario: The Save Changes button is clickable and on-click it updates all the fields successfully.
    When The user is in the MyProfile page
    Then Edit the ADDRESS and PIN field with any valid data
    And Click on the Save Changes button