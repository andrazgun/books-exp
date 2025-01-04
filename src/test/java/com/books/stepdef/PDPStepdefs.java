package com.books.stepdef;

import com.books.pages.ProductDto;
import com.books.utils.TestContextSetup;
import io.cucumber.java.en.Then;

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
                .withFailMessage("Expected word to be '%s', but got '%s'", productPrice, pdpProductPrice)
                .isEqualTo(productPrice);
    }
}