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

    @When("I click Login button on Login Page")
    public void iClickLoginButtonOnLoginPage() {

    }

    @And("I click Login button")
    public void iClickLoginButton() {
    }

    @When("I insert email {string} and click the email button")
    public void iInsertEmailEmailAndClickTheEmailButton(String email) {
        testContextSetup.loginPage.insertEmail(email);
        testContextSetup.loginPage.clickEmailButton();
        testContextSetup.loginPage.waitForPageLoad();
    }

    @When("I insert password {string} and click the Login button")
    public void iInsertThePasswordAndClickTheLoginButton(String password) {
        testContextSetup.loginPage.insertPassword(password);
        testContextSetup.loginPage.clickLoginButton();
        testContextSetup.loginPage.waitForPageLoad();
    }

    @Then("I should see the Login Page")
    public void iShouldSeeTheLoginPage() {
        String actualTitle = testContextSetup.headerNav.getActualPageTitle();
        String expectedTitle = testContextSetup.loginPage.getExpectedPageTitle();
        assertThat(expectedTitle).as("Page title contains %s name", expectedTitle)
                .contains(actualTitle);
    }

    @Given("I navigate to Login Page")
    public void iNavigateToLoginPage() {
        testContextSetup.loginPage.openPage();
    }

    @Then("I should see the Login button")
    public void iShouldSeeTheLoginButton() {
        assertThat(testContextSetup.loginPage.getLoginButtonElement().isDisplayed())
                .withFailMessage("Expected element to be displayed, but it was not.")
                .isTrue();
    }
}
