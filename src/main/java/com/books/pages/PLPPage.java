package com.books.pages;

import org.openqa.selenium.WebDriver;

public class PLPPage extends BasePage {

    public PLPPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getCurrentUrl() {
        return super.getCurrentUrl();
    }

    public boolean isCategoryPresentInUrl(String categoryName) {
        return getCurrentUrl().toLowerCase().contains(categoryName.toLowerCase());
    }
}