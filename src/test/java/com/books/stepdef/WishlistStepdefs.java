package com.books.stepdef;

import com.books.pages.ProductDto;
import com.books.utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WishlistStepdefs {
    TestContextSetup testContextSetup;

    public WishlistStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

//    @Then("confirmation is displayed showing that the product was added to the cart")
//    public void confirmationIsDisplayed() {
//        ProductDto productDto = TestContextSetup.scenarioSession.get("product", ProductDto.class);
//        String productDtoTitle = productDto.getTitle();
//        String confirmationText = testContextSetup.cartPage.getCartAddedText();
//        assertThat(confirmationText).containsIgnoringCase(productDtoTitle);
//    }

    @Then("I should see the book in the wishlist section")
    public void shouldSeeTheBook(String message) {
//        String actualMessage = testContextSetup.cartPage.getEmptyCartConfirmation();
//        assertThat(actualMessage)
//                .withFailMessage("Expected the message to contain '%s', but the actual message was '%s'", message, actualMessage)
//                .contains(message);
    }
}