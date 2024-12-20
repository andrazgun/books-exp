package stepdef;

import com.books.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.books.pages.BasePage.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageStepdefs {

    private HomePage homePage = new HomePage(driver);

    @Given("I am on the Books Express homepage")
    public void iAmOnTheBooksExpressHomepage() {
        homePage.openPage();
        String actualURL = homePage.getActualPageURL();
        String expectedURL = homePage.getExpectedPageUrl();
        assertThat(expectedURL).as("Home page URL is %s", expectedURL)
                .contains(actualURL);
    }

    @When("I search for {string}")
    public void iSearchFor(String bookName) {
        homePage.searchForBook(bookName);
    }

    @Then("I should see a results page with {string}")
    public void iShouldSeeAResultsPageWith(String bookName) {
        String title = homePage.getActualPageTitle();
        assertThat(title).as("%s title contains %s name", title, bookName)
                .contains(bookName);
//        homePage.closePage();
    }
}
