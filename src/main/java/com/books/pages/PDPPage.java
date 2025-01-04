package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PDPPage extends BasePage {

    private final By productSelector = By.cssSelector("[id='main-row']");
    private final By productPrice = By.cssSelector("[class='buy box'] > div > div > h4");
    private final By addToCartButton = By.xpath("//*[contains(@class, 'add2cart')]");

    public PDPPage(WebDriver driver) {
        super(driver);
    }

    public double getProductPrice() {
        return getDoubleBy(productPrice);
    }

    public String getProductTitle() {
        return getTextBy(productSelector);
    }

    @Override
    public String getCurrentUrl() {
        return super.getCurrentUrl();
    }

    public void clickAddToCartButton() {
        clickButton(addToCartButton);
    }

}