package com.books.pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage implements Page {

    private String expectedPageUrl = "https://www.books-express.ro/cart";
    private String expectedPageTitle = "Coș de cumpărături";


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getActualPageTitle() {
        return super.getActualPageTitle();
    }


}
