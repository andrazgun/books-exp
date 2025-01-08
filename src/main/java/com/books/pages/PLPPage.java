package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static com.books.utils.JavaScriptUtils.scrollScreenDown;
import static com.books.utils.TestContextSetup.scenarioSession;

public class PLPPage extends BasePage {

    private final By productListSelector = By.cssSelector("[class='list']");
    private final By productAnchorSelector = By.cssSelector("[class='list'] > article > section > h2 > a");
    private final By productPrice = By.cssSelector("[class='list'] > article > section > div:nth-child(5)");
    private final By productTitle = By.cssSelector("[class='list'] > article > section > h2");

    public PLPPage(WebDriver driver) {
        super(driver);
    }

    public double getSelectedProductPrice(int index) {
        WebElement selectedProductPrice = getElementByIndexFromLimitedListOfElements(productPrice, index);
        return getDouble(selectedProductPrice);
    }

    public String getSelectedProductTitle(int index) {
        WebElement selectedProductTitle = getElementByIndexFromLimitedListOfElements(productTitle, index);
        return getOnlyText(selectedProductTitle);
    }

    public WebElement getSelectedProductAnchor(int index) {
        return getElementByIndexFromLimitedListOfElements(productAnchorSelector, index);
    }

    public void captureProductDetails(int index) {
        String productTitle = getSelectedProductTitle(index);
        double productPrice = getSelectedProductPrice(index);
        ProductDto productDto = new ProductDto(productTitle, productPrice);
        scenarioSession.put("product", productDto);
    }

    public void clickOnSelectedProductByIndex(int index) throws IOException {
        scrollScreenDown();
        scrollScreenDown();
        WebElement selectedProduct = getSelectedProductAnchor(index);
        clickButton(selectedProduct);
    }


    @Override
    public String getCurrentUrl() {
        return super.getCurrentUrl();
    }

    public boolean isCategoryPresentInUrl(String categoryName) {
        return getCurrentUrl().toLowerCase().contains(categoryName.toLowerCase());
    }
}