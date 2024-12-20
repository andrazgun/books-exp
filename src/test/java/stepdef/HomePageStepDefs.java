package stepdef;

import com.books.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageStepDefs {

    private WebDriver driver;
    private HomePage homePage;

    @Given("I am on the Books Express homepage")
    public void iAmOnTheBooksExpressHomepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.openPage();
    }

    @When("I search for {string}")
    public void iSearchFor(String bookName) {
        homePage.searchForBook(bookName);
    }

    @Then("I should see a results page with {string}")
    public void iShouldSeeAResultsPageWith(String bookName) {
        String title = homePage.getPageTitle();
        assertThat(title).
                as("%s title contains %s name", title, bookName)
                .contains(bookName);
                driver.quit();
    }
}
