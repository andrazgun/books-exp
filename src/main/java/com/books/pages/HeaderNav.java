package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderNav extends BasePage{


    private By cartIcon = By.cssSelector("[id='show-cart']");
    private By accountIcon = By.cssSelector("[id='show-user']");
    private By listIcon = By.cssSelector("[id='show-lists']");
    private By accountButton = By.cssSelector("[href='/login']");

  public HeaderNav(WebDriver driver) {
      super(driver);
    }

    public void hoverOverElement() {
        super.hoverOverElement(driver.findElement(accountIcon));
    }

    public void clickAccountButton() {
      driver.findElement(accountButton).click();
    }
}
