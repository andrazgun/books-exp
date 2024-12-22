package stepdef;

import com.books.pages.PLPPage;
import io.cucumber.java.en.Then;

import static com.books.pages.BasePage.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class PLPStepdefs {

    PLPPage plpPage = new PLPPage(driver);

    @Then("the {string} product list page opens")
    public void theProductProductListPageOpens(String productCategory) {
        assertThat(plpPage.getActualPageURL()).containsIgnoringCase(productCategory);
    }
}
