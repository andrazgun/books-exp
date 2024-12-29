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
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
        driver.get(url);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getExpectedUrl() {
        return this.expectedPageUrl;
    }

    public String getExpectedTitle() {
        return this.expectedPageTitle;
    }

    public String getCurrentTitle() {
        return driver.getTitle();
    }

    public WebElement getClickableBaseElement(By element) {
        waitForElementToBeClickable(driver.findElement(element));
        return getBaseWebElement(element);
    }

    public void waitForElementToBeVisible(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void hoverOverElement(WebElement target) {
        Actions actions = new Actions(driver);
        actions.moveToElement(target).perform();
    }

    public void hoverOverElement(By element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getBaseWebElement(element));
    }

    public WebElement getBaseWebElement(By element) {
        return driver.findElement(element);
    }

    public void enterText(String text, By element) {
        waitForElementToBeClickable(getBaseWebElement(element));
        getBaseWebElement(element).clear();
        getBaseWebElement(element).sendKeys(text);
    }

    public String getText(By element) {
        return getBaseWebElement(element).getText();
    }

    public void clickButton(By element) {
        waitForElementToBeClickable(getBaseWebElement(element));
        getBaseWebElement(element).click();
    }

    public void clickButton(WebElement target) {
        waitForElementToBeClickable(target);
        target.click();
    }

    public void waitForElementToBeClickable(WebElement target) {
        wait.until(ExpectedConditions.elementToBeClickable(target));
    }

    public List<String> getLimitedListWithElementsText(By element, int elementsLimit) {
        List<WebElement> elementsList = driver.findElements(element);
        return elementsList.stream()
                .limit(elementsLimit)
                .map(WebElement::getText)
                .toList();
    }

    public List<WebElement> getListOfElements (By element) {
        return driver.findElements(element);
    }

    public WebElement getElementFromLimitedListOfElements(By element, int listLength, int index) {
        List<WebElement> elementsList = driver.findElements(element);
        return elementsList.stream()
                .limit(listLength)
                .toList()
                .get(index);
    }

    public void printWebElementTexts(By locator) {
        driver.findElements(locator)
                .stream()  // Get list of WebElements based on the By locator
                .map(WebElement::getText)  // Extract text from each WebElement
                .forEach(text -> System.out.println("Text: [" + text + "] Length: " + text.length()));
    }

    public WebElement findElementByName(By locator, String name, int limit) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (limit < 1) {
            throw new IllegalArgumentException("Limit must be greater than 0.");
        }
        return driver.findElements(locator)
                .stream()
                .peek(element -> System.out.println("Element text: [" + element.getText() + "]")) // Debug
                .limit(limit)  // Limit the stream to 'limit' elements
                .filter(element -> matchesName(name, element.getText()))  // Match based on the name
                .findFirst()  // Get the first match
                .orElseThrow(() -> new IllegalArgumentException("No matching WebElement found for name: " + name));  // Throw exception if no match found
    }

    private static boolean matchesName(String inputText, String elemText) {
        String normInputText = inputText.trim().toLowerCase().replaceAll("\\s", "");
        String normElemText = elemText.trim().toLowerCase().replaceAll("\\s", "");

        System.out.println("Comparing input: [" + normInputText + "] with element: [" + normElemText + "]");
        return normElemText.contains(normInputText);
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