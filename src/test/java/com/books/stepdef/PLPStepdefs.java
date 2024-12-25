package com.books.stepdef;

import com.books.hook.GlobalHooks;
import com.books.pages.PLPPage;
import com.books.utils.PageObjectFactory;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class PLPStepdefs {

    private PLPPage plpPage;

    public PLPStepdefs() {
        PageObjectFactory pageObjectFactory = new PageObjectFactory(GlobalHooks.driver);
        this.plpPage = pageObjectFactory.createPage(PLPPage.class);
    }

    @Then("the {string} product list page opens")
    public void theProductProductListPageOpens(String productCategory) {
        assertThat(plpPage.getActualPageUrl()).containsIgnoringCase(productCategory);
    }
}
