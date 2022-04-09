Feature: Functionalities in the MyCards page.

  Background:
    Given The user navigates to the link
    And The user is logged in using valid credentials
    And The user navigates to the MyCards page

  Scenario: A card is visible having the correct name of the user and a card number.
    When The user is in the MyCards page
    Then A card is visible with the name of the user and a card number

  Scenario: The View Transactions button is clickable and on-click it navigates to the My Transactions page.
    When The user is in the MyCards page
    Then Click on the View Transactions button