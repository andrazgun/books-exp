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
