package com.books.stepdef;

import com.books.utils.TestContextSetup;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WishlistStepdefs {
    TestContextSetup testContextSetup;

    public WishlistStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("I should see the book in the wishlist section")
    public void shouldSeeTheBook(String message) {
        String actualMessage = testContextSetup.cartPage.getEmptyCartConfirmation();
        assertThat(actualMessage)
                .withFailMessage("Expected the message to contain '%s', but the actual message was '%s'", message, actualMessage)
                .contains(message);
    }
}