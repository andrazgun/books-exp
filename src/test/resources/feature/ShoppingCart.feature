Feature: Shopping Cart Functionality

  Background:
    Given I navigate to Homepage
    And I click accept all cookies button

  @wip
  Scenario: Add and remove a product from the cart
    Given I hover over the "Products" dropdown
    And I click the product category named "Lifestyle"
    Then the "lifestyle" product list page opens
    When I click the book number 1 from the PLP page
    Then the product detail page opens
#    When I click the "Add to cart" button
#    Then the confirmation page is displayed showing the book was added to the cart
#    And the "Go to Checkout" button is displayed
#    When I click "Go to Checkout"
#    Then the cart page opens and the product is displayed in the cart
#    When I click the "Delete product" button
#    And I reload the page
#    Then the cart page is empty
