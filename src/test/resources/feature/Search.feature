Feature: Search Functionality

  Background:
    Given I navigate to Homepage
    And I click accept all cookies button

  Scenario: Searching for a specific book returns a list of specific books
    Given I search for "Selenium Testing"
    Then I should see a search result with "Selenium Testing"

  Scenario: Search for a non-existing product
    Given I search for "NonExistentBook123"
    Then I should see a message "No results found"
