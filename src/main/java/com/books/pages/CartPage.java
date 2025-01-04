package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final String expectedPageUrl = "https://www.books-express.ro/cart";
    private final String expectedPageTitle = "Coș de cumpărături";
    private final By cartAddedText = By.cssSelector("[id='cart-added-text']");
    private final By finalizeOrderButton = By.cssSelector("[class='button danger full icon']");
    private final By cartDetails = By.cssSelector("[class='cart-details']");
    private final By cartItems = By.cssSelector("[id='cart-items']");
    private final By quantityInput = By.cssSelector("[class='qty small']");
    private final By cartEmptyConfirmation = By.xpath("//*[contains(@class, 'cart-empty')]");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        super.openPage(expectedPageUrl);
    }

    @Override
    public String getCurrentTitle() {
        return super.getCurrentTitle();
    }

     public String getCartAddedText() {
        waitForElementToBeVisible(cartAddedText);
       return getTextBy(cartAddedText);
    }

    public String getCartDetails() {
        return getTextBy(cartDetails);
    }

    public String getCartItems() {
        return getTextBy(cartItems);
    }

    public WebElement getFinalizeOrderButton() {
        return getBaseWebElement(finalizeOrderButton);
    }

    public void clickFinalizeOrderButton() {
        clickButton(finalizeOrderButton);
    }

    public void editQuantity(String quantity) {
        enterText(quantity, quantityInput);

    }

    public String getEmptyCartConfirmation() {
        return getTextBy(cartEmptyConfirmation);
    }


}