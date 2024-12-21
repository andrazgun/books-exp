Feature: Search books on Books Express

  Background:
    Given I am on the Books Express homepage
    And I click accept all cookies button

  Scenario: Search for a specific book
    Given I search for "Selenium Testing"
    Then I should see a results page with "Selenium Testing"

