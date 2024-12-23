package com.books.stepdef;

import com.books.pages.HomePage;
import com.books.pages.PageObjectManager;
import io.cucumber.java.en.Given;

import static com.books.pages.BasePage.driver;

public class ShoppingCartStepdefs {

    PageObjectManager pageObjectManager = new PageObjectManager(driver);
    HomePage homePage = pageObjectManager.createPage(HomePage.class);

    @Given("I hover over the {string} dropdown")
    public void iHoverOverTheDropdown(String text) {
        homePage.hoverOverProductsDropdown();
    }
}
