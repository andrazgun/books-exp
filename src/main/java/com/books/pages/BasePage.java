package com.books.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class BasePage extends PageObjectManager implements Page {

    public String expectedPageUrl;
    public BasePage(WebDriver driver) { super(driver); }

    @Override
    public void openPage() {
        super.openPage(this.expectedPageUrl);
    }

    @Override
    public void closePage() {
        super.closePage();
    }

    public String getExpectedPageUrl() {
        return expectedPageUrl;
    }

    @Override
    public String getActualPageURL() {
        return super.getActualPageURL();
    }

    @Override
    public String getActualPageTitle() {
        return super.getActualPageTitle();
    }

    public WebElement getClickableBaseElement(By element) {
        waitUntilElementIsClickable(driver.findElement(element));
        return getBaseElement(element);
    }

    public WebElement getViewableBaseElement(By element) {
        waitUntilElementIsClickable(driver.findElement(element));
        return getBaseElement(element);
    }

    @Override
    public WebElement getBaseElement(By element) {
        return super.getBaseElement(element);
    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
