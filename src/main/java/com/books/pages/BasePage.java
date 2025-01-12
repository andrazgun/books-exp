package com.books.pages;

import com.books.utils.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.books.utils.Constants.LIST_LIMIT;

public abstract class BasePage implements Page {

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

    public void waitForElementToBeClickable(WebElement target) {
        wait.until(ExpectedConditions.elementToBeClickable(target));
    }

    public void hoverOverElement(WebElement target) {
        Actions actions = new Actions(driver);
        actions.moveToElement(target).perform();
    }

    public void hoverOverByElement(By element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getBaseWebElement(element));
    }

    public WebElement getBaseWebElement(By element) {
        return driver.findElement(element);
    }

    public List<WebElement> getListOfElements(By element) {
        return driver.findElements(element);
    }

    public List<WebElement> getLimitedListOfElements(By element, int listLimit) {
        List<WebElement> elementsList = getListOfElements(element);
        return elementsList.stream()
                .limit(listLimit)
                .toList();
    }

    public void login(String email, By emailTextField, By emailButton, String password, By passwordTextField, By loginButton) {
        enterText(email, emailTextField);
        clickButton(emailButton);
        enterText(password, passwordTextField);
        clickButton(loginButton);
    }

    public void enterText(String text, By element) {
        waitForElementToBeClickable(getBaseWebElement(element));
        getBaseWebElement(element).clear();
        getBaseWebElement(element).sendKeys(text);
    }

    public String getTextBy(By element) {
        return getBaseWebElement(element).getText();
    }

    public String getOnlyText(WebElement target) {
        String text = target.getText();
        return text.replaceAll("[^a-zA-Z\\s]", "").trim();
    }

    public double getDoubleBy(By element) {
        String text = getTextBy(element);
        // Regular expression to find numbers (e.g., 123.45)
        String numberString = text.replaceAll("[^\\d.]", "");

        try {
            // Parse the extracted string to a double
            return Double.parseDouble(numberString);
        } catch (NumberFormatException e) {
            System.err.println("Unable to parse price from text: " + text);
            throw new RuntimeException("Invalid price format in element text: " + text, e);
        }
    }

    public double getDouble(WebElement target) {
        String text = target.getText();
        // Regular expression to find numbers (e.g., 123.45)
        String numberString = text.replaceAll("[^\\d.]", "");

        try {
            // Parse the extracted string to a double
            return Double.parseDouble(numberString);
        } catch (NumberFormatException e) {
            System.err.println("Unable to parse price from text: " + text);
            throw new RuntimeException("Invalid price format in element text: " + text, e);
        }
    }

    public void clickButton(By element) {
        waitForElementToBeClickable(getBaseWebElement(element));
        getBaseWebElement(element).click();
    }

    public void clickButton(WebElement target) {
        waitForElementToBeClickable(target);
        target.click();
    }

    public List<String> getElementsTextFromALimitedList(By element) {
        List<WebElement> elementsList = getListOfElements(element);
        return elementsList.stream()
                .limit(LIST_LIMIT)
                .map(WebElement::getText)
                .toList();
    }

    public WebElement getElementByIndexFromLimitedListOfElements(By element, int index) {
        List<WebElement> elementsList = getListOfElements(element);
        return elementsList.stream()
                .limit(LIST_LIMIT)
                .toList()
                .get(index);
    }

    public void printElementsTextsFromLimitedListOfElements(By locator) {
        getListOfElements(locator)
                .stream()  // Get list of WebElements based on the By locator
                .map(WebElement::getText)  // Extract text from each WebElement
                .limit(LIST_LIMIT)
                .forEach(text -> System.out.println("Text: [ " + text + " ] Length: [ " + text.length() + " ]"));
    }

    public WebElement getElementByNameFromLimitedListOfElements(By locator, String name, int limit) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (limit < 1) {
            throw new IllegalArgumentException("Limit must be greater than 0.");
        }
        return getListOfElements(locator)
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

    private static boolean matchesNumber(double actualValue, double expectedValue) {
        System.out.println("Actual value: " + actualValue);
        System.out.println("Expected value: " + expectedValue);

        // Compare the two double values
        return Double.compare(actualValue, expectedValue) == 0;
    }

    public WebElement getElementByTextFromListOfElements(String elementName, By listOfElementsLocator) {
        List<WebElement> elementsList = getListOfElements(listOfElementsLocator);
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