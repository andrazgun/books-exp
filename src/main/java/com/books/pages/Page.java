package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Page {

    void refreshPage();

    void waitForPageLoad();

    String getCurrentUrl();

    String getExpectedUrl();

    String getExpectedTitle();

    String getCurrentTitle();

    void hoverOverElement(WebElement target);

    WebElement getBaseWebElement(By element);

    void clickButton(By element);
}