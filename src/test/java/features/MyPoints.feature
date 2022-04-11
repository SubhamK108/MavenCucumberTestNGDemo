Feature: Functionalities in the MyPoints page.

  Background:
    Given The user navigates to the link
    And The user is logged in using valid credentials
    And The user navigates to the MyPoints page

  @LowPriority
  Scenario: The Redeem-Catalogue and Redeem-Vouchers buttons are clickable and on-click they navigate to the respective pages.
    When The user is in the MyPoints page
    Then Click on the Redeem-Catalogue and Redeem-Vouchers buttons