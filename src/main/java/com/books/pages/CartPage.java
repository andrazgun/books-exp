package com.books.pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final String expectedPageUrl = "https://www.books-express.ro/cart";
    private final String expectedPageTitle = "Coș de cumpărături";


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        super.openPage(expectedPageUrl);
    }

    @Override
    public String getCurrentTitle() {
        return super.getCurrentTitle();
    }
}