@Regression
Feature: Login Functionality

  Background:
    Given I navigate to Homepage
    And I click accept all cookies button

  Scenario: Logged in customer can access User Details page
    Given I hover over Account icon on Header
    When I click Login button on Header
    Then I should see the Login Page
    When I enter email "agtest1@yopmail.com" on Login page
    And I click Email button
    And I enter password "Test!1234"
    And I click Login button
    And I navigate to Homepage
    And I hover over Account icon on Header
    And I click "detalii personale"
    Then I should see "Detalii personale" section

#    Then I should see User Details component

  Scenario: Logged in customer can access User Details page
    Given I hover over Account icon on Header
    When I click Login button on Header
    Then I should see the Login Page
    When I enter email "agtest1@yopmail.com" on Login page
    And I click Email button
    And I enter password "Test!1234"
    And I click Login button
    And I navigate to Homepage
    And I hover over Account icon on Header
    And I click Detalii Personale button on Header
    Then I should see User Details component