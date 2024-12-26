package com.books.stepdef;

import com.books.utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationStepdefs {
    TestContextSetup testContextSetup;

    public RegistrationStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("I navigate to Registration page")
    public void navigateToHomepage() {
        testContextSetup.registrationPage.openPage();
        String actualUrl = testContextSetup.registrationPage.getActualPageUrl();
        String expectedUrl = testContextSetup.registrationPage.getExpectedPageUrl();

        assertThat(actualUrl)
                .withFailMessage("Expected the page URL to contain '%s', but the actual URL was '%s'", expectedUrl, actualUrl)
                .contains(expectedUrl);
    }

    @When("I enter password again {string}")
    public void enterPasswordAgain(String password) {
        testContextSetup.registrationPage.enterPasswordConfirm(password);
    }

    @And("I click Register button")
    public void clickRegisterButton() throws IOException {
        testContextSetup.registrationPage.clickRegisterButton();
    }

    @And("I enter first name {string}")
    public void enterFirstName(String firstName) {
        testContextSetup.registrationPage.enterFirstName(firstName);
    }

    @And("I enter last name {string}")
    public void enterLastName(String lastName) {
        testContextSetup.registrationPage.enterLastName(lastName);
    }

    @Then("I should see an error message")
    public void shouldSeeAMessage() {
        boolean isErrorDisplayed = testContextSetup.registrationPage.getEmailErrorElement().isDisplayed();
        String isErrorDisplayedText = testContextSetup.registrationPage.getEmailErrorMessage();
        assertThat(isErrorDisplayed)
                .withFailMessage("Expected the error message to be displayed, but it was not.")
                .isTrue();
    }

    @Given("I fill in the following details:")
    public void fillInDetails(DataTable dataTable) {
        Map<String, String> details = dataTable.asMap(String.class, String.class);
        details.forEach((field, value) ->
                testContextSetup.registrationPage.fillField(field, value)
        );
    }
    @Then("I should see the following error messages:")
    public void verifyErrorMessages(DataTable dataTable) {
        Map<String, String> expectedErrorMessages = dataTable.asMap(String.class, String.class);
        expectedErrorMessages.forEach((field, expectedMessage) -> {
            String actualMessage = testContextSetup.registrationPage.getErrorMessageForField(field);
            assertThat(actualMessage)
                    .withFailMessage("Expected error message for '%s' to be '%s', but was '%s'", field, expectedMessage, actualMessage)
                    .isEqualTo(expectedMessage);
        });
    }


}
