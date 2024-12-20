package stepdef;

import com.books.pages.HeaderNav;
import com.books.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HeaderStepdefs {

    private HomePage homePage;
    private HeaderNav headerNav;


    @When("I hover over Account icon")
    public void iHoverOverAccountIcon() {
        headerNav.hoverOverElement();
    }

    @And("I click Login button")
    public void iClickLoginButton() {
        headerNav.clickAccountButton();
    }

    @Then("I should see the Login Page")
    public void iShouldSeeTheLoginPage() {
    }
}
