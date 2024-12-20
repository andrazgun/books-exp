package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderNav extends BasePage{


    private By cartIcon = By.cssSelector("[id='show-cart']");
    private By accountIcon = By.cssSelector("[id='show-user']");
    private By listIcon = By.cssSelector("[id='show-lists']");

  public HeaderNav(WebDriver driver) {
      super(driver);
    }
}
