package com.books.stepdef;

import com.books.utils.TestContextSetup;
import io.cucumber.java.en.Given;

public class ShoppingCartStepdefs {
    TestContextSetup testContextSetup;

    public ShoppingCartStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("I hover over the {string} dropdown")
    public void iHoverOverTheDropdown(String text) {
        testContextSetup.homePage.hoverOverProductsDropdown();
    }
}