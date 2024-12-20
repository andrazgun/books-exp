package com.books.pages;

import org.openqa.selenium.WebDriver;

public class ListPage extends  BasePage{

    private String expectedPageUrl = "https://www.books-express.ro/cart";
    private String expectedPageTitle = "Coș de cumpărături";

    public ListPage(WebDriver driver) {
        super(driver);
    }

    public String getExpectedPageTitle() {
        return expectedPageTitle;
    }

    public String getExpectedPageUrl() {
        return expectedPageUrl;
    }
}
