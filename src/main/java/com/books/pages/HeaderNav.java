package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderNav extends BasePage {

    private final By cartIcon = By.cssSelector("[id='show-cart']");
    private final By cartButton = By.cssSelector("[class='button special full']");
    private final By accountIcon = By.cssSelector("[id='show-user']");
    private final By loginButton = By.cssSelector("[href='/login']");
    private final By userDetailsButton = By.cssSelector("[href='/user/details']");
    private final By logoutButton = By.cssSelector("[href='/logout']");
    private final By listIcon = By.cssSelector("[id='show-lists']");
    private final By listButton = By.cssSelector("[href='/user/wishlist']");
    private final By personalDetailsButton = By.cssSelector("[href='/user/details']");
    private final By userDataDropdown = By.cssSelector("[id='user-data'] > ul > li");

    public HeaderNav(WebDriver driver) {
        super(driver);
    }

    public void hoverOverAccountIcon() {
        hoverOverElement(getBaseWebElement(accountIcon));
    }

    public void hoverOverListIcon() {
        hoverOverElement(getBaseWebElement(listIcon));
    }

    public void hoverOverCartIcon() {
        hoverOverElement(getBaseWebElement(cartIcon));
    }

    public void clickLoginButton() {
        clickButton(loginButton);
    }

    public void clickUserDetailsButton() {
        clickButton(userDetailsButton);
    }

    public void clickLogoutButton() {
        clickButton(logoutButton);
    }

    public void clickListButton() {
        clickButton(listButton);
    }

    public void clickCartButton() {
        clickButton(cartButton);
    }

    public String getPersonalDetailsText() {
        return getTextBy(personalDetailsButton);
    }

    public void clickSelectedSection(String name) {
        WebElement sectionSelected = getElementByNameFromLimitedListOfElements(userDataDropdown, name, 5);
        sectionSelected.click();
    }
}