package com.books.pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    private String url = "https://www.books-express.ro/cart";
    private String expectedPageTitle = "Coș de cumpărături";


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String setExpectedPageTitle() {
        return expectedPageTitle;
    }

}
