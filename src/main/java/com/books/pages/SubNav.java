package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubNav extends BasePage{

    private final By subNavElement = By.cssSelector("[id='breadcrumbs']");
    private final By sortFilterElement = By.cssSelector("[id='sort-filter']");
    private final By filterPriceAsc = By.cssSelector("[id='sort-data'] > ul > li:nth-child(3) > a");

    public SubNav(WebDriver driver) {
        super(driver);
    }

    public String getSubNavText() { return getText(subNavElement); }

    public void  hoverOverSortingFilter() {
        hoverOverElement(getBaseWebElement(sortFilterElement));
    }

    public void clickFilterPriceAsc() {
        clickButton(filterPriceAsc);
    }
}

