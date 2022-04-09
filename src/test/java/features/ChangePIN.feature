Feature: Functionalities in the ChangePIN page.

  Background:
    Given The user navigates to the link
    And The user is logged in using valid credentials
    And The user navigates to the ChangePIN page

  Scenario Outline: The OLD PIN, NEW PIN and CONFIRM PIN fields don't accept any input other than 4-digit numbers.
    When The user is in the ChangePIN page
    Then Provide invalid data for OLD PIN, NEW PIN and CONFIRM PIN fields from "Invalid_PINS" sheet and row <rowNumber>
    And On clicking the Change button, nothing happens
    Examples:
      | rowNumber |
      | 1         |
      | 2         |
      | 3         |

  Scenario Outline: The OLD PIN, NEW PIN and CONFIRM PIN fields accept any 4-digit number as input.
    When The user is in the ChangePIN page
    Then Provide valid data for OLD PIN, NEW PIN and CONFIRM PIN fields from "Valid_PINS" sheet and row <rowNumber>
    And On clicking the Change button, a SUCCESS message is shown and PIN is changed
    Examples:
      | rowNumber |
      | 1         |
      | 2         |
      | 3         |