#Feature: Search Functionality
#
#  Background:
#    Given I navigate to Homepage
#    And I click accept all cookies button
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
