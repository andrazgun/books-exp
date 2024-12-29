package com.books.stepdef;

import com.books.utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SubNavStepdefs {
    TestContextSetup testContextSetup;

    public SubNavStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("^I should see the keyword (.+)$")
    public void iShouldSeeASearchResultListWithName(String text) {
        System.out.println(testContextSetup.subNav.getSubNavText());
        String fullText = testContextSetup.subNav.getSubNavText();
        String extractedText = fullText.substring(fullText.indexOf("\"") + 1, fullText.lastIndexOf("\""));
        assertThat(extractedText)
                .withFailMessage(() -> String.format("Expected word to be '%s', but got '%s'", text, extractedText))
                .contains(text);
    }

    @When("I hover over the sorting filter")
    public void iHoverOverTheSortingFilter() {
        testContextSetup.subNav.hoverOverSortingFilter();
    }

    @And("I click filter by price ascending")
    public void iClickFilterByPriceAscending() {
        testContextSetup.subNav.clickFilterPriceAsc();
    }

    @Then("the product list should be ordered by price ascending")
    public void theProductListShouldBeOrderedByPriceAscending() {
        List<Double> prices = testContextSetup.search.getProductPrices();

        List<Double> sortedPrices = prices.stream().sorted().toList();
        assertThat(prices.equals(sortedPrices))
                .withFailMessage("The product list should be ordered by price in ascending order but it was not.")
                .isTrue();
    }
}
