package com.books.stepdef;

import com.books.pages.HeaderNav;
import com.books.pages.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.books.pages.BasePage.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class HeaderStepdefs {

    PageObjectManager pageObjectManager = new PageObjectManager(driver);
    HeaderNav headerNav = pageObjectManager.createPage(HeaderNav.class);

    @When("I hover over Account icon on the Header")
    public void iHoverOverAccountIcon() {
        headerNav.hoverOverAccountIcon();
    }

    @And("I click Login button on Header")
    public void iClickLoginButton() {
        headerNav.clickLoginButton();
    }

    @Then("I should see {string} on the Header")
    public void iShouldSeePersonalDetailsOnTheHeader(String actualText) {
        headerNav.hoverOverAccountIcon();
        String expectedText = headerNav.getPersonalDetailsText();
        assertThat(expectedText).as("Expected text contains %s", expectedText)
                .contains(actualText);

    }

    @And("I click User Details button on Header")
    public void iClickButtonOnHeader() {
        headerNav.clickUserDetailsButton();
    }
}
