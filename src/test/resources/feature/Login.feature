Feature: Login

  Background:
    Given I navigate to Homepage
    And I click accept all cookies button

  Scenario: Logged in customer can access User Details page
    Given I hover over Account icon
    When I click Login button on Header
    Then I should see the Login Page
    When I insert email "agtest1@yopmail.com" and click the email button
    And I insert password "Test!1234" and click the Login button
    And I navigate to Homepage
    And I hover over Account icon
    And I click "Detalii Personale" button on Header
    Then I should see User Details component