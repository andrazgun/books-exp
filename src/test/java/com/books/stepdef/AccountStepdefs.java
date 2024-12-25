package com.books.stepdef;
import com.books.utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountStepdefs {

    TestContextSetup testContextSetup;

    public AccountStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("I should see User Details Page")
    public void iShouldSeeUserDetailsPage() {
        String actualPageUrl = testContextSetup.accountPage.getActualPageUrl();
        String expectedPageUrl = testContextSetup.accountPage.getExpectedPageUrl();
        assertThat(expectedPageUrl).as("Page URL is %s ", expectedPageUrl)
                .contains(actualPageUrl);
    }

    @And("I navigate to User Details page")
    public void iNavigateToUserDetailsPage() {
        testContextSetup.accountPage.openPage();
    }

    @Then("I should see User Details component")
    public void iShouldUserDetailsComponent() {
        assertThat(testContextSetup.accountPage.getViewablePersonalDetailsElement().isDisplayed())
                .withFailMessage("Expected component is displayed, but it was not.")
                .isTrue();
    }
}