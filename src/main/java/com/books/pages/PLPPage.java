package com.books.pages;

import org.openqa.selenium.WebDriver;

public class PLPPage extends BasePage implements Page {


    public PLPPage(WebDriver driver) {
        super(driver);
    }

    public String getActualPageURL() {
        return driver.getCurrentUrl();
    }

    public boolean isCategoryPresentInUrl(String categoryName) {
        return getActualPageURL().toLowerCase().contains(categoryName.toLowerCase());
    }

}
