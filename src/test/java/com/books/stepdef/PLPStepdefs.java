package com.books.stepdef;

import com.books.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class PLPStepdefs {

    TestContextSetup testContextSetup;

    public PLPStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("the {string} product list page opens")
    public void productListPageOpens(String productCategory) {
        assertThat(testContextSetup.plpPage
                .getCurrentUrl())
                .containsIgnoringCase(productCategory);
    }

    @When("I click the book number {int} from the PLP page")
    public void iClickTheBookNumberInThePLPPage(int index) {
        testContextSetup.plpPage.clickOnSelectedProductByIndex(index);
    }
}