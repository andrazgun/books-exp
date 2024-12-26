package com.books.pages;

import com.books.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public abstract class BasePage {

    protected WebDriver driver;
    public String expectedPageUrl;
    public String expectedPageTitle;
    private static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME_OUT));
    }

    public void openPage(String url) {
        if (driver == null){
            throw new IllegalStateException("WebDriver is not initialized.");
        }
        driver.get(url);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public String getActualPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getExpectedPageUrl() {
        return this.expectedPageUrl;
    }

    public String getExpectedPageTitle() {
        return this.expectedPageTitle;
    }

    public String getActualPageTitle() {
        return driver.getTitle();
    }

    public WebElement getClickableBaseElement(By element) {
        waitUntilElementIsClickable(driver.findElement(element));
        return getBaseElement(element);
    }

    public void waitUntilElementIsVisible(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public WebElement getBaseElement(By element) {
        return driver.findElement(element);
    }

    public void enterText(String text, By element) {
        waitUntilElementIsClickable(getBaseElement(element));
        getBaseElement(element).clear();
        getBaseElement(element).sendKeys(text);
    }

    public String getText(By element) {
        return getBaseElement(element).getText();
    }

    public void clickButton(By element) {
        waitUntilElementIsClickable(getBaseElement(element));
        getBaseElement(element).click();
    }

    public void waitUntilElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement getFirstElementFromLimitedListOfElements(By element) {
        List<WebElement> elementsList = driver.findElements(element);
        return elementsList.stream()
                .limit(5)
                .toList()
                .get(0);
    }

    public List<String> getElementsTitleFromList(By elementCategory) {
        List<WebElement> elementsList = driver.findElements(elementCategory);
        return elementsList.stream()
                .limit(3)
                .map(WebElement::getText)
                .toList();
    }

    public WebElement getElementFromElementsCategory(String elementName, By elementCategory) {
        List<WebElement> elementsList = driver.findElements(elementCategory);
        return elementsList.stream()
                .filter(elem -> elem.getText().equalsIgnoreCase((elementName)))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Category with name " + elementName + " not found."));
    }

    public void waitForPageLoad() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
}