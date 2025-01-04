package com.books.stepdef;

import com.books.pages.ProductDto;
import com.books.utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CartStepdefs {
    TestContextSetup testContextSetup;

    public CartStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("I hover over the {string} dropdown")
    public void hoverOverTheDropdown(String text) {
        testContextSetup.homePage.hoverOverProductsDropdown();
    }

    @Then("confirmation is displayed showing that the product was added to the cart")
    public void confirmationIsDisplayed() {
        ProductDto productDto = TestContextSetup.scenarioSession.get("product", ProductDto.class);
        String productDtoTitle = productDto.getTitle();
        String confirmationText = testContextSetup.cartPage.getCartAddedText();

        assertThat(confirmationText).containsIgnoringCase(productDtoTitle);
    }

    @And("Finalize order button is displayed")
    public void finalizeOrderButtonIsDisplayed() {
        assertThat(testContextSetup.cartPage.getFinalizeOrderButton()
                .isDisplayed())
                .withFailMessage("Expected component is displayed, but it was not.")
                .isTrue();
    }

    @When("I click Finalize Order button")
    public void clickFinalizeOrderButton() {
        testContextSetup.cartPage.clickFinalizeOrderButton();
    }

    @Then("the cart page opens and the product is displayed in the cart")
    public void theCartPageOpensAndTheProductIsDisplayedInTheCart() {
        ProductDto productDto = TestContextSetup.scenarioSession.get("product", ProductDto.class);
        String productDtoTitle = productDto.getTitle();
        String cartItemsText = testContextSetup.cartPage.getCartItems();
        assertThat(cartItemsText)
                .contains(productDtoTitle);
    }

    @When("I change the quantity to {string}")
    public void iChangeTheQuantityTo(String quantity) {
        testContextSetup.cartPage.editQuantity(quantity);
    }

    @Then("I should see a message {string} on Checkout page")
    public void shouldSeeAMessageOnCheckoutPage(String message) {
        String actualMessage = testContextSetup.cartPage.getEmptyCartConfirmation();
        assertThat(actualMessage)
                .withFailMessage("Expected the message to contain '%s', but the actual message was '%s'", message, actualMessage)
                .contains(message);
    }
}