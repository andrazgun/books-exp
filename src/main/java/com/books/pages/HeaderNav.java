package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderNav extends BasePage{

    private final By cartIcon = By.cssSelector("[id='show-cart']");
    private final By cartButton = By.cssSelector("[class='button special full']");
    private final By accountIcon = By.cssSelector("[id='show-user']");
    private final By accountButton = By.cssSelector("[href='/login']");
    private final By listIcon = By.cssSelector("[id='show-lists']");
    private final By listButton = By.cssSelector("[href='/user/wishlist']");
    private final By personalDetailsButton = By.cssSelector("[href='/user/details']");

  public HeaderNav(WebDriver driver) {
      super(driver);
    }

    public void hoverOverAccountIcon() {
        super.hoverOverElement(driver.findElement(accountIcon));
    }

    public void hoverOverListIcon() {
        super.hoverOverElement(driver.findElement(listIcon));
    }

    public void hoverOverCartIcon() {
        super.hoverOverElement(driver.findElement(cartIcon));
    }

    public void clickAccountButton() {
      driver.findElement(accountButton).click();
    }

    public void clickListButton() {
        driver.findElement(listButton).click();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    public String getPersonalDetailsText() {
      return driver.findElement(personalDetailsButton).getText();
    }
}
