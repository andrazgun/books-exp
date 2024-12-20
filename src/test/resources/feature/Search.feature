Feature: Search books on Books Express

  @WIP
  Scenario: Search for a specific book
    Given I am on the Books Express homepage
    When I search for "Selenium Testing"
    Then I should see a results page with "Selenium Testing"

  Scenario: Go to Login page
    Given I am on the Books Express homepage
    When I hover over Account icon
    And I click Login button
    Then I should see the Login Page