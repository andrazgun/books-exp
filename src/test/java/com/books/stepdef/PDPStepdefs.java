package com.books.stepdef;

import com.books.pages.ProductDto;
import com.books.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class PDPStepdefs {

    TestContextSetup testContextSetup;

    public PDPStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("the product detail page opens")
    public void productDetailsPageOpens() {
        ProductDto productDto = TestContextSetup.scenarioSession.get("product", ProductDto.class);
        System.out.println(productDto.toString());
        String productTitle = productDto.getTitle();
        double productPrice = productDto.getPrice();

        double pdpProductPrice = testContextSetup.pdpPage.getProductPrice();
        String pdpCurrentTitle = testContextSetup.pdpPage.getCurrentTitle();

        assertThat(pdpCurrentTitle)
                .containsIgnoringCase(productTitle);
        assertThat(pdpProductPrice)
                .withFailMessage("Expected word to be '%s', but was '%s'", productPrice, pdpProductPrice)
                .isEqualTo(productPrice);
    }

    @When("I click Add to cart button")
    public void clickAddToCartButton() {
        testContextSetup.pdpPage.clickAddToCartButton();
    }

    @When("I click Add to Wishlist button")
    public void clickAddToWishlistButton() {
        testContextSetup.pdpPage.clickAddToWishlistButton();
    }

    @Then("I should see a confirmation popup with message {string}")
    public void iShouldSeeAConfirmationPopupWithMessage(String message) {
        String actualMessage = testContextSetup.pdpPage.getNotificationPopupText();
        assertThat(actualMessage)
                .withFailMessage("Expected the message to contain '%s', but the actual message was '%s'", message, actualMessage)
                .contains(message);
    }

    @When("I click close button on the popup")
    public void iClickCloseButtonOnThePopup() {
        testContextSetup.pdpPage.closeNotificationPopup();
    }
}