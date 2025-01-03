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
    public void productDetailsPageOpens() {

        String productTitle = TestContextSetup.scenarioSession.getAsString("book name");
        String pdpCurrentUrl = testContextSetup.pdpPage.getCurrentUrl();
        String pdpCurrentTitle = testContextSetup.pdpPage.getCurrentTitle();

        System.out.println("PDP Url: " + pdpCurrentUrl);
        System.out.println("PDP Title: " + pdpCurrentTitle);

//        check this assert
        assertThat(pdpCurrentTitle)
                .containsIgnoringCase(productTitle);

//        assertThat(pdpProductPrice)
//                .withFailMessage("Expected the message to contain '%s', but the actual message was '%s'", pdpProductPrice, plpProductPrice)
//                .containsIgnoringCase(pdpProductPrice);
    }

}