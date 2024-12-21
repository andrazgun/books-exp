Feature: Homepage actions

  Scenario: When Homepage opens, I can accept the cookies dialog
    Given I am on the Books Express homepage
    And Cookie dialog is displayed
    When I click accept all cookies button
    Then The cookies dialog is not displayed