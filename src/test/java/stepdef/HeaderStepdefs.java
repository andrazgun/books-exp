package stepdef;

import com.books.pages.HeaderNav;
import com.books.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.books.pages.BasePage.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class HeaderStepdefs {

    private HeaderNav headerNav = new HeaderNav(driver);
    private LoginPage loginPage = new LoginPage(driver);

    @When("I hover over Account icon")
    public void iHoverOverAccountIcon() {
        headerNav.hoverOverAccountIcon();
    }

    @And("I click Login button")
    public void iClickLoginButton() {
        headerNav.clickAccountButton();
    }

    @Then("I should see the Login Page")
    public void iShouldSeeTheLoginPage() {
        String actualTitle = headerNav.getActualPageTitle();
        String expectedTitle = loginPage.getExpectedPageTitle();
        assertThat(expectedTitle).as("Page title contains %s name", expectedTitle)
                .contains(actualTitle);
    }
}
