@Regression
Feature: Account feature

  Background:
    Given I navigate to Homepage
    And I click accept all cookies button

  Scenario: User can access personal details after logging in
    Given I navigate to Login Page
    When I enter email "agtest1@yopmail.com" on Login page
    And I click Email button
    And I click accept all cookies button
    And I enter password "Test!1234"
    And I click Login button
    And I navigate to Homepage
    And I hover over Account icon on Header
    And I click Detalii Personale button on Header
    Then I should see User Details Page


  #TO DO
#Feature: Account Details Editing
#Scenarios for editing account details.
#
#  Scenario: Update account name successfully
#    Given I am logged into my account
#    When I navigate to the account details page
#    And I update the account name to "John Doe"
#    And I save the changes
#    Then I should see my account name updated to "John Doe"
#
#  Scenario: Try to save with empty name
#    Given I am logged into my account
#    When I navigate to the account details page
#    And I clear the account name field
#    And I save the changes
#    Then I should see an error message "Name field cannot be empty"
