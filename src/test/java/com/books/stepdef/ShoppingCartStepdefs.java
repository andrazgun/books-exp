package com.books.stepdef;

import com.books.hook.GlobalHooks;
import com.books.pages.HomePage;
import com.books.utils.PageObjectFactory;
import io.cucumber.java.en.Given;


public class ShoppingCartStepdefs {
    private HomePage homePage;

    public ShoppingCartStepdefs() {
        PageObjectFactory pageObjectFactory = new PageObjectFactory(GlobalHooks.driver);
        this.homePage = pageObjectFactory.createPage(HomePage.class);
    }

    @Given("I hover over the {string} dropdown")
    public void iHoverOverTheDropdown(String text) {
        homePage.hoverOverProductsDropdown();
    }
}
