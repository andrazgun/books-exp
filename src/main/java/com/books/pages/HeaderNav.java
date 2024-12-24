package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

  public HeaderNav(WebDriver driver) {
      super(driver);
    }

    public void hoverOverAccountIcon() {
        super.hoverOverElement(getBaseElement(accountIcon));
    }

    public void hoverOverListIcon() {
        super.hoverOverElement(getBaseElement(listIcon));
    }

    public void hoverOverCartIcon() {
        super.hoverOverElement(getBaseElement(cartIcon));
    }

    public void clickLoginButton() {
      getBaseElement(loginButton).click();
    }

    public void clickUserDetailsButton() {
        getBaseElement(userDetailsButton).click();
    }

    public void clickLogoutButton() {
      getBaseElement(logoutButton).click();
    }

    public void clickListButton() {
        getBaseElement(listButton).click();
    }

    public void clickCartButton() {
        getBaseElement(cartButton).click();
    }

    public String getPersonalDetailsText() {
      return getBaseElement(personalDetailsButton).getText();
    }
}
