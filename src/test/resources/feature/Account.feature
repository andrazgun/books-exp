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
