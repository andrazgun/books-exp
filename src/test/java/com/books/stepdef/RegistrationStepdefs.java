package com.books.stepdef;

import com.books.utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationStepdefs {
    TestContextSetup testContextSetup;

    public RegistrationStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("I navigate to Registration page")
    public void iNavigateToHomepage() {
        testContextSetup.registrationPage.openPage();
        assertThat(testContextSetup.registrationPage.getActualPageUrl()).as("Expected Page URL to be %s", testContextSetup.homePage.getActualPageUrl())
                .contains(testContextSetup.registrationPage.getActualPageUrl());
    }

    @When("I enter password again {string}")
    public void enterPasswordAgain(String password) {
        testContextSetup.registrationPage.enterPasswordAgain(password);
//        testContextSetup.loginPage.waitForPageLoad();
    }

    @And("I click Register button")
    public void iClickRegisterButton() throws IOException {
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
    public void iShouldSeeAMessage() {
        assertThat(testContextSetup.registrationPage.getEmailErrorElement().isDisplayed())
                .withFailMessage("Expected element is displayed, but it was not.")
                .isTrue();
    }
}
