package com.books.pages;

import org.openqa.selenium.WebDriver;

public class PLPPage extends BasePage {

    public PLPPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getActualPageUrl() {
        return super.getActualPageUrl();
    }

    public boolean isCategoryPresentInUrl(String categoryName) {
        return getActualPageUrl().toLowerCase().contains(categoryName.toLowerCase());
    }
}