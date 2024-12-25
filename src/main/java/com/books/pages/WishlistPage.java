package com.books.pages;

import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {

    private final String expectedPageUrl = "https://www.books-express.ro/user/wishlist";
    private final String expectedPageTitle = "Liste Express";

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getExpectedPageTitle() {
        return this.expectedPageTitle;
    }


    @Override
    public String getExpectedPageUrl() {
        return this.expectedPageUrl;
    }
}
