package stepdef;

import com.books.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.books.pages.BasePage.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageStepDefs {

    private HomePage homePage;

    @Given("I am on the Books Express homepage")
    public void iAmOnTheBooksExpressHomepage() {
        homePage = new HomePage(driver);
        homePage.openPage();
        String actualURL = homePage.getPageURL();
        String expectedURL = homePage.expectedURL();
        assertThat(actualURL).as("Home page URL is %s", actualURL, expectedURL)
                .contains(expectedURL);
    }

    @When("I search for {string}")
    public void iSearchFor(String bookName) {
        homePage.searchForBook(bookName);
    }

    @Then("I should see a results page with {string}")
    public void iShouldSeeAResultsPageWith(String bookName) {
        String title = homePage.getPageTitle();
        assertThat(title).as("%s title contains %s name", title, bookName)
                .contains(bookName);
        homePage.closePage();
    }
}
