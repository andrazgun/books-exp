package com.books.stepdef;

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
    public void productListPageOpens(String productName) {
        String plpProductPrice = testContextSetup.plpPage.getProductPrice();
        String pdpProductPrice = testContextSetup.pdpPage.getProductPrice();
        assertThat(pdpProductPrice)
                .withFailMessage("Expected the message to contain '%s', but the actual message was '%s'", pdpProductPrice, plpProductPrice)
                .containsIgnoringCase(pdpProductPrice);
    }

}