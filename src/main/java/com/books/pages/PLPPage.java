package com.books.pages;

import com.books.session.ScenarioSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

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

    public List<WebElement> getLimitedProductList(int limit) {
        return getLimitedListOfElements(productListSelector, limit);
    }

    public String getProductPrice() {
        return getBaseWebElement(productPrice).getText();
    }

    public String getProductTitle() {
        return getBaseWebElement(productTitle).getText();
    }

    public WebElement getSelectedProductAnchor(int index) {
        return getElementByIndexFromLimitedListOfElements(productAnchorSelector, index);
    }

    public void clickOnSelectedProductByIndex(int index) throws IOException {
        scenarioSession.put("book name", getProductTitle()); //fix this to pass the data to ProductDto object
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