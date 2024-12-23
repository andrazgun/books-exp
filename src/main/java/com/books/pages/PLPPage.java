package com.books.pages;

import org.openqa.selenium.WebDriver;

public class PLPPage extends BasePage implements Page {


    public PLPPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getActualPageURL() {
        return super.getActualPageURL();
    }

    public boolean isCategoryPresentInUrl(String categoryName) {
        return getActualPageURL().toLowerCase().contains(categoryName.toLowerCase());
    }

}
