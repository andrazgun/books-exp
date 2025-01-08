Feature: Shopping Cart Functionality

  Background:
    Given I navigate to Homepage
    And I click accept all cookies button

  @wip
  Scenario: Add and remove a product from the cart
    Given I hover over the "Products" dropdown
    And I click the product category named "Lifestyle"
    Then the "lifestyle" product list page opens
    When I click the book number 0 from the PLP page
    Then the product detail page opens
    When I click accept all cookies button
    And I click Add to cart button
    Then confirmation is displayed showing that the product was added to the cart
    And Finalize order button is displayed
    When I click Finalize Order button
    Then the cart page opens and the product is displayed in the cart
    When I change the quantity to "0"
    And I reload the page
    Then I should see a message "Coșul de cumpăraturi este gol. Navigați prin categorii sau folosiți bara de căutare pentru a găsi produsele dorite." on Checkout page

  #TO DO
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
