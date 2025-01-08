@Regression
Feature: Wishlist Functionality

  Background:
    Given I navigate to Homepage
    And I click accept all cookies button

  Scenario: Add a product to the wishlist
    Given I select "Lists" from the dropdown
#    When I search for "Clean Code"
#    And I add the product to the wishlist
#    Then I should see the product "Clean Code" in the wishlist

#  Scenario: Remove a product from the wishlist
#    Given I have a product "Clean Code" in the wishlist
#    When I remove the product from the wishlist
#    Then the product "Clean Code" should no longer appear in the wishlist