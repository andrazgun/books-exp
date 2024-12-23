package com.books.stepdef;

import com.books.pages.PLPPage;
import com.books.pages.PageObjectManager;
import io.cucumber.java.en.Then;

import static com.books.pages.BasePage.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class PLPStepdefs {

    PageObjectManager pageObjectManager = new PageObjectManager(driver);
    PLPPage plpPage = pageObjectManager.createPage(PLPPage.class);

    @Then("the {string} product list page opens")
    public void theProductProductListPageOpens(String productCategory) {
        assertThat(plpPage.getActualPageURL()).containsIgnoringCase(productCategory);
    }

}
