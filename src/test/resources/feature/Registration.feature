Feature: Negative Registration Flow
Scenarios for validating incorrect inputs during registration.

  Background:
    Given I navigate to Registration page
    And I click accept all cookies button

  Scenario: Register with invalid email
    Given I enter email "invalid email" on Registration page
    And I enter first name "first name"
    And I enter last name "last name"
    And I enter password "invalid password"
    And I enter password again "invalid password"
    And I click Register button
    Then I should see an error message

  Scenario: Register with invalid data - empty fields
    Given I fill in the following details:
      | Email            | invalid email |
      | First Name       |               |
      | Last Name        |               |
      | Password         |               |
      | Password Confirm |               |
    And I click Register button
    Then I should see the following error messages:
      | Email            | Te rugăm verifică adresa de email, formatul este incorect |
      | First Name       | Te rugăm să-ți introduci prenumele                        |
      | Last Name        | Te rugăm să-ți introduci numele                           |
      | Password         | Te rugăm să introduci parola nouă.                        |
      | Password Confirm | Te rugăm reintroduci parola pentru confirmare.            |

  Scenario: Register with invalid data - password validation rules
    Given I fill in the following details:
      | Email            | invalid email |
      | First Name       |               |
      | Last Name        |               |
      | Password         | 1             |
      | Password Confirm | 2             |
    And I click Register button
    Then I should see the following error messages:
      | Email            | Te rugăm verifică adresa de email, formatul este incorect                   |
      | First Name       | Te rugăm să-ți introduci prenumele                                          |
      | Last Name        | Te rugăm să-ți introduci numele                                             |
      | Password         | Te rugăm să introduci o parolă de minim 8 caractere.                        |
      | Password Confirm | Confirmarea nu corespunde cu parola, te rugăm să verifici datele introduse. |