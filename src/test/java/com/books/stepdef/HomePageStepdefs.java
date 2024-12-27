package com.books.stepdef;

import com.books.utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageStepdefs {
    TestContextSetup testContextSetup;

    public HomePageStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("I navigate to Homepage")
    public void navigateToHomepage() {
        testContextSetup.homePage.openPage();
        assertThat(testContextSetup.homePage.getCurrentUrl()).as("Expected Page URL to be %s", testContextSetup.homePage.getCurrentUrl())
                .contains(testContextSetup.homePage.getCurrentUrl());
    }

    @And("Cookie dialog is displayed")
    public void cookieDialogIsDisplayed() {
        boolean isCookieDialogDisplayed = testContextSetup.homePage.getClickableCookiesDialogElement().isDisplayed();
        assertThat(isCookieDialogDisplayed)
                .withFailMessage("Expected the cookieBot dialog to be displayed, but it was not.")
                .isTrue();
    }

    @When("I click accept all cookies button")
    public void clickAcceptAllCookiesButton() {
        testContextSetup.homePage.clickAcceptAllCookiesButton();
    }

    @Then("The cookies dialog is not displayed")
    public void cookiesDialogIsNotDisplayed() {
        assertThat(testContextSetup.homePage.getCookiesDialogElement().isDisplayed())
                .withFailMessage("Expected the cookieBot dialog to not be displayed, but it was.")
                .isFalse();
    }

    @And("I reload the page")
    public void reloadPage() {
        testContextSetup.homePage.refreshPage();
    }

    @And("I click the product category named {string}")
    public void clickTheProductCategoryNamed(String categoryName) {
        testContextSetup.homePage.clickOnProductCategory(categoryName);
    }
}