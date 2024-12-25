Feature: Negative Registration Flow
Scenarios for validating incorrect inputs during registration.

  Scenario: Register with invalid email
    Given I navigate to Registration page
    When I enter the email "invalidemail"
    And I enter a valid password "Test@123"
    And I click the Register button
    Then I should see an error message "Invalid email format"

  Scenario: Register with a short password
    Given I navigate to Registration page
    When I enter a valid email "test@example.com"
    And I enter the password "123"
    And I click the Register button
    Then I should see an error message "Password must be at least 8 characters"
