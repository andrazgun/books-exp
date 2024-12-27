package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class Search extends BasePage {

    private final By searchResultList = By.cssSelector("[id='results-list'] [class='list']");
    private final By searchResultError = By.cssSelector("#results-list > div.align-center > h3:first-of-type");
    private final By searchField = By.cssSelector("[id='search']");
    private final By searchButton = By.cssSelector("[class='button special search right']");
    private final By productPrice = By.cssSelector("[id='results-list'] > div > article > section > div:nth-child(4)");
    private final By productPriceSelector = By.cssSelector("[class='color-theme-5']");

    public Search(WebDriver driver) {
        super(driver);
    }

    public void enterProductName(String productName) {
        enterText(productName, searchField);
    }

    public void clickSearchButton() {
        clickButton(searchButton);
    }

    public List<String> getSearchResultList() {
        return getElementsTitleFromList(searchResultList);
    }

    public WebElement getSearchResultError() {
        return getBaseWebElement(searchResultError);
    }

    public List<WebElement> getProductsFromSearchList() {
        return driver.findElements(searchResultList);
    }

    public List<Double> getProductPrices() {
        List<Double> prices = getProductsFromSearchList().stream()
                .map(product -> product.findElement(productPriceSelector).getText()) // Extract price text
                .limit(5)
                .map(priceText -> {
                    // Parse the price directly in the lambda
                    String cleanPriceText = priceText.replaceAll("[^\\d.]", "");
                    return Double.parseDouble(cleanPriceText);
                })
                .collect(Collectors.toList());
        return prices;
    }

}