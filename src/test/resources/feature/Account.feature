Feature: Account feature

  Scenario: User can access personal details after logging in
    Given I navigate to Login Page
    And I click accept all cookies button
    When I insert email "agtest1@yopmail.com" and click the email button
    And I insert password "Test!1234" and click the Login button
    And I navigate to Homepage
    And I hover over Account icon on Header
    And I click Detalii Personale button on Header
    Then I should see User Details Page

Feature: Account Details Editing
Scenarios for editing account details.

  Scenario: Update account name successfully
    Given I am logged into my account
    When I navigate to the account details page
    And I update the account name to "John Doe"
    And I save the changes
    Then I should see my account name updated to "John Doe"

  Scenario: Try to save with empty name
    Given I am logged into my account
    When I navigate to the account details page
    And I clear the account name field
    And I save the changes
    Then I should see an error message "Name field cannot be empty"
