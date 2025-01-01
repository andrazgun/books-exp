package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static com.books.utils.JavaScriptUtils.scrollIntoView;
import static com.books.utils.JavaScriptUtils.scrollScreenDown;

public class PLPPage extends BasePage {

    private final By productListSelector = By.cssSelector("[class='list']");
    private final By productSelector = By.cssSelector("[class='list'] > article > section > h2");
    private final By productPrice = By.cssSelector("[class='list'] > article > section > div:nth-child(5)");
    private final By productTitle = By.cssSelector("[class='list'] > article > section > h2");


    public PLPPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getLimitedProductList(int limit) {
        return getLimitedListOfElements(productListSelector, limit);
    }

    public String getProductPrice() {
        return getBaseWebElement(productPrice).getText();
    }

    public String getProductTitle() {
        return getBaseWebElement(productTitle).getText();
    }

    public WebElement getSelectedProduct(int index) {
        return getElementByIndexFromLimitedListOfElements(productSelector, index);
    }

    public void clickOnSelectedProductByIndex(int index) throws IOException {
        scrollScreenDown();
        scrollScreenDown();
        WebElement selectedProduct = getSelectedProduct(index);
        hoverOverElement(selectedProduct);
        clickButton(selectedProduct);
        waitForPageLoad();
    }


    @Override
    public String getCurrentUrl() {
        return super.getCurrentUrl();
    }

    public boolean isCategoryPresentInUrl(String categoryName) {
        return getCurrentUrl().toLowerCase().contains(categoryName.toLowerCase());
    }
}