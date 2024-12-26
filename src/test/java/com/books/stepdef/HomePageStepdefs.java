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
    public void iNavigateToHomepage() {
        testContextSetup.homePage.openPage();
        assertThat(testContextSetup.homePage.getActualPageUrl()).as("Expected Page URL to be %s", testContextSetup.homePage.getActualPageUrl())
                .contains(testContextSetup.homePage.getActualPageUrl());
    }

    @When("I search for {string}")
    public void iSearchFor(String bookName) {
        testContextSetup.homePage.searchForBook(bookName);
    }

    @Then("I should see a search result with {string}")
    public void iShouldSeeASearchResult(String bookName) {
        String title = testContextSetup.homePage.getActualPageTitle();
        assertThat(title).as("%s title contains %s name", title, bookName)
                .contains(bookName);
    }

    @And("Cookie dialog is displayed")
    public void cookieDialogIsDisplayed() {
        assertThat(testContextSetup.homePage.getClickableCookiesDialogElement())
                .as("Base element from cookieBotDialog")
                .isNotNull();

        assertThat(testContextSetup.homePage.getClickableCookiesDialogElement().isDisplayed())
                .withFailMessage("Expected the cookieBot dialog to be displayed, but it was not.")
                .isTrue();
    }

    @When("I click accept all cookies button")
    public void iClickAcceptAllCookiesButton() {
        testContextSetup.homePage.clickAcceptAllCookiesButton();
    }

    @Then("The cookies dialog is not displayed")
    public void theCookiesDialogIsNotDisplayed() {
        assertThat(testContextSetup.homePage.getCookiesDialogElement().isDisplayed())
                .withFailMessage("Expected the cookieBot dialog to not be displayed, but it was.")
                .isFalse();
    }

    @And("I reload the page")
    public void iReloadThePage() {
        testContextSetup.homePage.refreshPage();
    }

    @And("I click the product category named {string}")
    public void iClickTheProductCategoryNamed(String categoryName) {
        testContextSetup.homePage.clickOnProductCategory(categoryName);
    }
}