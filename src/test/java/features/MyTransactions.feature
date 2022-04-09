Feature: Functionalities in the MyTransactions page.

  Background:
    Given The user navigates to the link
    And The user is logged in using valid credentials
    And The user navigates to the MyTransactions page

  Scenario: The View, Download and Reset buttons are not clickable when there are no past transactions.
    When The user is in the MyTransactions page
    Then Click on the View, Download and Reset buttons

  Scenario: The From and To filters are not usable when there are no past transactions.
    When The user is in the MyTransactions page
    Then Use the From and To table filters

  Scenario: The past transactions table displays "No Transaction Found" when there are no past transactions.
    When The user is in the MyTransactions page
    Then The past transactions table displays "No Transaction Found" text