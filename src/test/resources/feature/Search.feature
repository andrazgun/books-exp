Feature: Search books on Books Express

  Scenario: Search for a specific book
    Given I am on the Books Express homepage
    When I search for "Selenium Testing"
    Then I should see a results page with "Selenium Testing"

