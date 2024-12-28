package com.books.pages;

import com.books.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

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

    public WebElement getElementFromLimitedListOfElements(By element, int listLength, int index) {
        List<WebElement> elementsList = driver.findElements(element);
        return elementsList.stream()
                .limit(listLength)
                .toList()
                .get(index);
    }

    public List<String> getListWithElementsText(By element) {
        List<WebElement> elementsList = driver.findElements(element);
        return elementsList.stream()
                .limit(3)
                .map(WebElement::getText)
                .toList();
    }

    public void printWebElementTexts(By locator) {
        driver.findElements(locator).stream()  // Get list of WebElements based on the By locator
                .map(WebElement::getText)  // Extract text from each WebElement
                .forEach(System.out::println);  // Print each text to console
    }

    public WebElement findElement(By locator, String name, int limit) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (limit < 1) {
            throw new IllegalArgumentException("Limit must be greater than 0.");
        }

        // Find and filter the elements
        return driver.findElements(locator)
                .stream()
                .limit(limit)  // Limit the stream to 'limit' elements
                .filter(element -> matchesName(name, element.getText()))  // Match based on the name
                .findFirst()  // Get the first match
                .orElseThrow(() -> new IllegalArgumentException("No matching WebElement found for name: " + name));  // Throw exception if no match found
    }

    private static boolean matchesName(String name, String text) {
// Normalize both name and text by trimming and converting to lowercase
        String normalizedName = name.trim().toLowerCase().replaceAll("\\s", "");
        String normalizedText = text.trim().toLowerCase().replaceAll("\\s", "");

        // Match the provided name with specific expected text in the elements
        return (normalizedName.equals("new account") && normalizedText.contains("cont nou"))
                || (normalizedName.equals("log in") && normalizedText.contains("intră în cont"))
                || (normalizedName.equals("detalii personale") && normalizedText.contains("detalii personale"));
    }

    public WebElement getElementFromElementsCategory(String elementName, By elementCategory) {
        List<WebElement> elementsList = driver.findElements(elementCategory);
        return elementsList.stream()
                .filter(elem -> elem.getText().equalsIgnoreCase((elementName)))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Category with name " + elementName + " not found."));
    }

    public static List<WebElement> filterElements(List<WebElement> elements, String name, int limit) {
        return elements.stream()
                .filter(element -> element.getText().contains(name))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public void waitForPageLoad() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
}