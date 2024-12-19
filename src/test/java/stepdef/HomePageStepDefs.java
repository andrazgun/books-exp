package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageStepDefs {

    private WebDriver driver;
    private pages.HomePage homePage;

    @Given("I am on the Books Express homepage")
    public void i_am_on_the_books_express_homepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.books-express.ro/");
        homePage = new pages.HomePage(driver);
    }

    @When("I search for {string}")
    public void i_search_for(String bookName) {
        homePage.searchForBook(bookName);
    }

    @Then("I should see a results page with {string}")
    public void i_should_see_a_results_page_with(String bookName) {
        String title = homePage.getPageTitle();
        Assertions.assertThat(title).contains(bookName);
        System.out.println("pass");
        driver.quit();
    }
}
