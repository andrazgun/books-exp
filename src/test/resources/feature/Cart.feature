#Feature: Cart Management
#Scenarios for managing the cart.
#
#  Scenario: Add multiple products to the cart
#    Given I navigate to the homepage
#    When I search for "Clean Code"
#    And I add the product to the cart
#    And I search for "Refactoring"
#    And I add the product to the cart
#    Then I should see 2 products in the cart
#
#  Scenario: Remove a product from the cart
#    Given I have "Clean Code" and "Refactoring" in my cart
#    When I remove "Refactoring" from the cart
#    Then I should see 1 product in the cart
#    And I should not see "Refactoring" in the cart
#
#  Scenario: Update product quantity
#    Given I have "Clean Code" in my cart with quantity 1
#    When I update the quantity to 3
#    Then I should see the total quantity as 3
#    And the total price should update correctly
