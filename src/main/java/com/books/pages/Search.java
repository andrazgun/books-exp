package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Search extends BasePage {

    private final By searchResultList = By.cssSelector("[id='results-list'] [class='list']");
    private final By searchResultError = By.cssSelector("#results-list > div.align-center > h3:first-of-type");
    private final By searchField = By.cssSelector("[id='search']");
    private final By searchButton = By.cssSelector("[class='button special search right']");

    public Search(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String bookName) {
        getBaseElement(searchField).clear();
        getBaseElement(searchField).sendKeys(bookName);
    }

    public void clickSearchButton() {
        getBaseElement(searchButton).click();
    }

    public List<String> getSearchResultList() {
        return getElementsTitleFromList(searchResultList);
    }

    public WebElement getSearchResultError() {
        return getBaseElement(searchResultError);
    }


}