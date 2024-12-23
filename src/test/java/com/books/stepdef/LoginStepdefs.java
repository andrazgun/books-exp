package com.books.stepdef;

import com.books.pages.HeaderNav;
import com.books.pages.LoginPage;
import com.books.pages.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.books.utils.BrowserUtils;

import static com.books.pages.BasePage.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepdefs {

    PageObjectManager pageObjectManager = new PageObjectManager(driver);
    HeaderNav headerNav = pageObjectManager.createPage(HeaderNav.class);
    LoginPage loginPage = pageObjectManager.createPage(LoginPage.class);

    @When("I click Login button on Login Page")
    public void iClickLoginButtonOnLoginPage() {

    }

    @And("I click Login button")
    public void iClickLoginButton() {
    }

    @When("I insert email {string} and click the email button")
    public void iInsertEmailEmailAndClickTheEmailButton(String email) {
        loginPage.insertEmail(email);
        loginPage.clickEmailButton();
        BrowserUtils.waitForPageLoad();
    }

    @When("I insert password {string} and click the Login button")
    public void iInsertThePasswordAndClickTheLoginButton(String password) {
        loginPage.insertPassword(password);
        loginPage.clickLoginButton();
        BrowserUtils.waitForPageLoad();
    }

    @Then("I should see the Login Page")
    public void iShouldSeeTheLoginPage() {
        String actualTitle = headerNav.getActualPageTitle();
        String expectedTitle = loginPage.getExpectedPageTitle();
        assertThat(expectedTitle).as("Page title contains %s name", expectedTitle)
                .contains(actualTitle);
    }

    @Given("I navigate to Login Page")
    public void iNavigateToLoginPage() {
        loginPage.openPage();
    }

    @Then("I should see the Login button")
    public void iShouldSeeTheLoginButton() {
        assertThat(loginPage.getLoginButtonElement().isDisplayed())
                .withFailMessage("Expected element to be displayed, but it was not.")
                .isTrue();
    }
}
