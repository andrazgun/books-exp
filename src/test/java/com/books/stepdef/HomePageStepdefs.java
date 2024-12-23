package com.books.stepdef;

import com.books.pages.BasePage;
import com.books.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.books.pages.BasePage.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageStepdefs {

    private BasePage basePage = new BasePage(driver);
    private HomePage homePage = new HomePage(driver);

    @Given("I navigate to Homepage")
    public void iNavigateToHomepage() {
        homePage.openPage();
        String actualPageURL = homePage.getActualPageURL();
        String expectedPageURL = homePage.getExpectedPageUrl();
        assertThat(expectedPageURL).as("Page URL is %s", expectedPageURL)
                .contains(actualPageURL);
    }

    @When("I search for {string}")
    public void iSearchFor(String bookName) {
        homePage.searchForBook(bookName);
    }

    @Then("I should see a search results page with {string}")
    public void iShouldSeeAResultsPageWith(String bookName) {
        String title = homePage.getActualPageTitle();
        assertThat(title).as("%s title contains %s name", title, bookName)
                .contains(bookName);
    }

    @And("Cookie dialog is displayed")
    public void cookieDialogIsDisplayed() {
        assertThat(homePage.getClickableCookiesDialogElement())
                .as("Base element from cookieBotDialog")
                .isNotNull();

        assertThat(homePage.getClickableCookiesDialogElement().isDisplayed())
                .withFailMessage("Expected the cookieBot dialog to be displayed, but it was not.")
                .isTrue();
    }

    @When("I click accept all cookies button")
    public void iClickAcceptAllCookiesButton() {
        homePage.clickAcceptAllCookiesButton();
    }

    @Then("The cookies dialog is not displayed")
    public void theCookiesDialogIsNotDisplayed() {
        assertThat(basePage.getCookiesDialogElement().isDisplayed())
                .withFailMessage("Expected the cookieBot dialog to not be displayed, but it was.")
                .isFalse();
    }

    @And("I reload the page")
    public void iReloadThePage() {
        homePage.refreshPage();
    }

    @And("I click the product category named {string}")
    public void iClickTheProductCategoryNamed(String categoryName) {
        homePage.clickOnProductCategory(categoryName);
    }
}
