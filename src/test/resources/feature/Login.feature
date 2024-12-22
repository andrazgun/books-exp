Feature: Login

  Background:
    Given I am on the Books Express homepage
    And I click accept all cookies button

  Scenario: Logged in customer can access the wishlist page
    Given I am on the Books Express homepage
    When I hover over Account icon
    And I click Login button on Header
    Then I should see the Login Page
    When I insert email "agtest1@yopmail.com" and click the email button
    And I insert password "Test!1234" and click the Login button
    And I reload the page
    When I hover over Account icon
    Then I should see "Detalii personale" on the Header