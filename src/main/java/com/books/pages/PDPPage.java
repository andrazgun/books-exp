package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PDPPage extends BasePage {

    private final By productSelector = By.cssSelector("[id='main-row']");
    private final By productPrice = By.cssSelector("[class='buy box'] > div > div > h4");

    public PDPPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrice() {
        return getBaseWebElement(productPrice).getText();
    }

    public String getProductTitle() {
        return super.getCurrentTitle();
    }

    @Override
    public String getCurrentUrl() {
        return super.getCurrentUrl();
    }

}