package com.books.pages;

import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {

    private final String expectedPageUrl = "https://www.books-express.ro/user/wishlist";
    private final String expectedPageTitle = "Liste Express";

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getExpectedTitle() {
        return this.expectedPageTitle;
    }


    @Override
    public String getExpectedUrl() {
        return this.expectedPageUrl;
    }
}