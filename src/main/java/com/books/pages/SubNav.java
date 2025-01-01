package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubNav extends BasePage {

    private final By subNavElement = By.cssSelector("[id='breadcrumbs']");
    private final By sortFilterElement = By.cssSelector("[id='sort-filter']");
    private final By sortFilterOptions = By.cssSelector("[id='sort-data'] [class='align-center']");
//    private final By filterPriceAsc = By.cssSelector("[id='sort-data'] > ul > li:nth-child(3) > a");

    public SubNav(WebDriver driver) {
        super(driver);
    }

    public String getSubNavText() {
        return getText(subNavElement);
    }

    public void hoverOverSortingFilter() {
        waitForElementToBeClickable(getBaseWebElement(sortFilterElement));
        hoverOverElement(getBaseWebElement(sortFilterElement));
        clickButton(sortFilterElement);
    }

    public WebElement getFilterPriceAscElem() {
        return getElementByIndexFromLimitedListOfElements(sortFilterOptions, 4, 2);
    }

    public void clickFilterPriceAsc() {
        clickButton(getFilterPriceAscElem());
    }
}

