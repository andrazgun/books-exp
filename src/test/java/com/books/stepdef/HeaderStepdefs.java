package com.books.stepdef;

import com.books.utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class HeaderStepdefs {
    TestContextSetup testContextSetup;

    public HeaderStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @When("I hover over Account icon on Header")
    public void hoverOverAccountIcon() {
        testContextSetup.headerNav.hoverOverAccountIcon();
    }

    @When("I hover over Lists icon on Header")
    public void hoverOverListIcon() {
        testContextSetup.headerNav.hoverOverListIcon();
    }

    @And("I click Login button on Header")
    public void clickLoginButton() {
        testContextSetup.headerNav.clickLoginButton();
    }

    @Then("I should see {string} on the Header")
    public void shouldSeePersonalDetailsOnTheHeader(String actualText) {
        testContextSetup.headerNav.hoverOverAccountIcon();
        String expectedText = testContextSetup.headerNav.getPersonalDetailsText();
        assertThat(expectedText)
                .withFailMessage("Expected text to contain '%s', but was '%s'", actualText, expectedText)
                .contains(actualText);
    }

    @And("I click Detalii Personale button on Header")
    public void clickUserDetailsButtonOnHeader() {
        testContextSetup.headerNav.clickUserDetailsButton();
    }

    @And("I click {string} from the Account dropdown")
    public void clickSelectedSectionFromAccountOnHeader(String selectedSection) {
        testContextSetup.headerNav.clickSelectedSectionFromUserData(selectedSection);
    }

    @And("I click {string} from the Wishlists dropdown")
    public void clickSelectedSectionFromWishlistsOnHeader(String selectedSection) {
        testContextSetup.headerNav.clickSelectedSectionFromWishlists(selectedSection);
    }
}
