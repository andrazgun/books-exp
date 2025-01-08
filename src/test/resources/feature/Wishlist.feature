@Regression
Feature: Wishlist Functionality

  Background:
    Given I navigate to Login Page
    And I click accept all cookies button
    And I am logged in with email "agtest1@yopmail.com" and password "Test!1234"

  Scenario: Add a product to the wishlist
    Given I hover over Lists icon on Header
    When I click "wishlist" from the Wishlists dropdown
    Then I should see "Liste Express" section
    When I hover over the "Products" dropdown
    And I click the product category named "Business"
    Then the "Business" product list page opens
    When I click the book number 2 from the PLP page
    Then the product detail page opens
    When I click accept all cookies button
    And I click Add to Wishlist button
    Then I should see a confirmation popup with message "Produsul a fost adăugat în listă"
    When I click close button on the popup
    And I hover over Lists icon on Header
    And I click "wishlist" from the Wishlists dropdown
    Then I should see the book in the wishlist section

#  Scenario: Remove a product from the wishlist
#    Given I have a product "Clean Code" in the wishlist
#    When I remove the product from the wishlist
#    Then the product "Clean Code" should no longer appear in the wishlist