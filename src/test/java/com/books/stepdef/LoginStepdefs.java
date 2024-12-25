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

//    @When("I click Login button on Login Page")
//    public void iClickLoginButtonOnLoginPage() {
//        testContextSetup.loginPage.clickLoginButton();
//    }

    @When("I click Login button")
    public void clickLoginButton() {
        testContextSetup.loginPage.clickLoginButton();
    }
    @When("I click Email button")
    public void clickEmailButton() {
        testContextSetup.loginPage.clickEmailButton();
    }

    @When("I enter email {string}")
    public void iInsertEmailEmail(String email) {
        testContextSetup.registrationPage.enterEmail(email);
//        testContextSetup.loginPage.waitForPageLoad();
    }

    @When("I enter password {string}")
    public void iInsertThePassword(String password) {
        testContextSetup.loginPage.insertPassword(password);
//        testContextSetup.loginPage.waitForPageLoad();
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