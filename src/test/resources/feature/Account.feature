Feature: Account

  Scenario: User can access personal details after logging in
    Given I navigate to Login Page
    And I click accept all cookies button
    When I insert email "agtest1@yopmail.com" and click the email button
    And I insert password "Test!1234" and click the Login button
    And I navigate to Homepage
    And I hover over Account icon on Header
    And I click Detalii Personale button on Header
    Then I should see User Details Page