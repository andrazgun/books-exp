package com.books.pages;

import org.openqa.selenium.WebDriver;

public class ListPage extends BasePage implements Page {

    private final String expectedPageUrl = "https://www.books-express.ro/user/wishlist";
    private final String expectedPageTitle = "Liste Express";

    public ListPage(WebDriver driver) {
        super(driver);
    }

    public String getExpectedPageTitle() {
        return expectedPageTitle;
    }

    @Override
    public String getExpectedPageUrl() {
        return expectedPageUrl;
    }
}
