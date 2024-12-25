Feature: Search Functionality

  Background:
    Given I navigate to Homepage
    And I click accept all cookies button

  Scenario: Searching for a specific book returns a list of specific books
    Given I search for "Selenium Testing"
    Then I should see a search results page with "Selenium Testing"
