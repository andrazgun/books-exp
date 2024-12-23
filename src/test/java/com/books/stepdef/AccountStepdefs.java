package com.books.stepdef;

import com.books.pages.AccountPage;
import com.books.pages.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.books.pages.BasePage.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountStepdefs {

    PageObjectManager pageObjectManager = new PageObjectManager(driver);
    AccountPage accountPage = pageObjectManager.createPage(AccountPage.class);

    @Then("I should see User Details Page")
    public void iShouldSeeUserDetailsPage() {
        String actualPageUrl = accountPage.getActualPageURL();
        String expectedPageUrl = accountPage.getExpectedPageUrl();
        assertThat(expectedPageUrl).as("Page URL is %s ", expectedPageUrl)
                .contains(actualPageUrl);
    }

    @And("I navigate to User Details page")
    public void iNavigateToUserDetailsPage() {
        accountPage.openPage();
    }

    @Then("I should see User Details component")
    public void iShouldUserDetailsComponent() {
        assertThat(accountPage.getViewablePersonalDetailsElement().isDisplayed())
                .withFailMessage("Expected component is displayed, but it was not.")
                .isTrue();
    }
}