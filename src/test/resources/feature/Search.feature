Feature: Search Functionality

  Background:
    Given I navigate to Homepage
    And I click accept all cookies button

  Scenario Outline: Searching for a specific keyword, the keyword is displayed
    Given I search for keyword <name>
    And I click Search button
    Then I should see the keyword <name>
    When I hover over the sorting filter
    And I click filter by price ascending
    Then the product list should be ordered by price ascending
    Examples:
      | name     |
      | Selenium |
      | Cucumber |

#
#  Scenario: Searching for a specific book returns a list of specific books
#    Given I search for "Selenium Testing"
#    And I click Search button
#    Then I should see a search result list
#
#  Scenario: Search for a non-existing product
#    Given I search for "NonExistentBook123"
#    And I click Search button
#    Then I should not see a search result list
#    And I should see a message "Îmi pare nespus de rău, dar nu am găsit în acest moment ceea ce îți dorești. Aș mai avea nevoie de puțin timp."
