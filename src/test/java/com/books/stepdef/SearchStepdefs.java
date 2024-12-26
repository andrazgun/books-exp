package com.books.stepdef;

import com.books.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepdefs {
    TestContextSetup testContextSetup;

    public SearchStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @When("I click Search button")
    public void clickSearchButton() {
        testContextSetup.search.clickSearchButton();
    }

    @Then("I should see a message {string}")
    public void shouldSeeAMessage(String message) {
        String actualMessage = testContextSetup.search.getSearchResultError().getText();
        assertThat(actualMessage)
                .withFailMessage("Expected the message to contain '%s', but the actual message was '%s'", message, actualMessage)
                .contains(message);
    }

    @When("I search for {string}")
    public void searchFor(String productName) {
        testContextSetup.search.searchForProduct(productName);
    }

    @Then("I should see a search result list")
    public void shouldSeeASearchResultList() {
        assertThat(testContextSetup.search.getSearchResultList())
                .withFailMessage("Expected the search result list to not be empty, but it was.")
                .isNotEmpty();
    }

    @Then("I should not see a search result list")
    public void shouldNotSeeASearchResultList() {
        assertThat(testContextSetup.search.getSearchResultList())
                .withFailMessage("Expected the search result list to be empty, but it was not.")
                .isEmpty();
    }
}
