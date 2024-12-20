package stepdef;

import com.books.pages.HeaderNav;
import com.books.pages.HomePage;
import com.books.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.books.pages.BasePage.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class HeaderStepdefs {

    private HomePage homePage;
    private HeaderNav headerNav;
    private LoginPage loginPage;

    @When("I hover over Account icon")
    public void iHoverOverAccountIcon() {
        headerNav = new HeaderNav(driver);
        loginPage = new LoginPage(driver);
        headerNav.hoverOverElement();
    }

    @And("I click Login button")
    public void iClickLoginButton() {
        headerNav.clickAccountButton();
    }

    @Then("I should see the Login Page")
    public void iShouldSeeTheLoginPage() {
        String actualTitle = headerNav.getPageTitle();
        String expectedTitle = loginPage.setExpectedPageTitle();
        assertThat(expectedTitle).as("Page title contains %s name", expectedTitle)
                .contains(actualTitle);
    }
}
