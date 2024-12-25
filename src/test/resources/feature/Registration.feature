Feature: Negative Registration Flow
Scenarios for validating incorrect inputs during registration.
Background:
  Given I navigate to Registration page
  And I click accept all cookies button

  Scenario: Register with invalid email
    Given I enter email "invalid email"
    And I enter first name "first name"
    And I enter last name "last name"
    And I enter password "invalid password"
    And I enter password again "invalid password"
    And I click Register button
    Then I should see an error message

#TO DO
#  Scenario: Register with a short password
#    Given I navigate to Registration page
#    When I enter email "invalidEmail"
#    And I enter password "123"
#    And I click Register button
#    Then I should see a message "Password must be at least 8 characters"
