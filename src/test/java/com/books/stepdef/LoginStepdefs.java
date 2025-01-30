package com.books.stepdef;

import com.books.utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepdefs {
    TestContextSetup testContextSetup;

    public LoginStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @When("I click Login button")
    public void clickLoginButton() {
        testContextSetup.loginPage.clickLoginButton();
    }

    @When("I click Email button")
    public void clickEmailButton() {
        testContextSetup.loginPage.clickEmailButton();
    }

    @When("I enter email {string} on Login page")
    public void enterEmailOnLoginPage(String email) {
        testContextSetup.loginPage.enterEmail(email);
    }

    @When("I enter password {string}")
    public void enterPassword(String password) {
        testContextSetup.loginPage.enterPassword(password);
    }

    @Then("I should see the Login Page")
    public void shouldSeeTheLoginPage() {
        String actualTitle = testContextSetup.headerNav.getCurrentTitle();
        String expectedTitle = testContextSetup.loginPage.getExpectedTitle();
        assertThat(expectedTitle)
                .withFailMessage("Expected the page title to contain '%s', but was '%s'", expectedTitle, actualTitle)
                .contains(actualTitle);
    }

    @Given("I navigate to Login Page")
    public void navigateToLoginPage() {
        testContextSetup.loginPage.openPage();
    }

    @Then("I should see the Login button")
    public void shouldSeeTheLoginButton() {
        assertThat(testContextSetup.loginPage
                .getLoginButtonElement()
                .isDisplayed())
                .withFailMessage("Expected element to be displayed, but it was not.")
                .isTrue();
    }

    @And("I am logged in with email {string} and password {string}")
    public void iAmLoggedIn(String email, String password) {
        testContextSetup.loginPage.login(email, password);
    }
}