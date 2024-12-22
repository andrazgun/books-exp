package com.books.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.BrowserUtils.waitUntilElementIsClickable;
import static utils.WebdriverFactory.getDriver;

public class BasePage implements Page {

    public String expectedPageUrl;
    public static WebDriver driver = getDriver("chrome");
    public WebDriverWait wait;
    public By cookieBotDialog = By.cssSelector("[id='CybotCookiebotDialog']");
    public By cookieBotFooter = By.cssSelector("[id='CybotCookiebotDialogFooter']");
    public By acceptAllCookiesButton = By.cssSelector("[id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Override
    public void openPage() {
        driver.get(expectedPageUrl);
    }

    public void clickAcceptAllCookiesButton() {
        try {
            if (getCookiesDialogElement().isDisplayed()) {
                getClickableBaseElement(acceptAllCookiesButton).click();

            }
        }
        catch (NoSuchElementException ignored) {
        }

    }

    public WebElement getClickableCookiesDialogElement() {
        return getClickableBaseElement(cookieBotDialog);
    }

    public WebElement getCookiesDialogElement() {
        return getBaseElement(cookieBotDialog);
    }

    @Override
    public void closePage() {
        driver.quit();
    }

    @Override
    public void reloadPage() {
        driver.navigate().refresh();
    }

    public String getExpectedPageUrl() {
        return expectedPageUrl;
    }

    public String getActualPageURL() {
        return driver.getCurrentUrl();
    }

    public String getActualPageTitle() {
        return driver.getTitle();
    }

    public WebElement getElementFromList(By element) {
        List<WebElement> elementsList = driver.findElements(element);
        List<WebElement> limitedElementsList = elementsList.stream()
                .limit(5)
                .toList();
        return limitedElementsList.get(0);
    }

    public WebElement getClickableBaseElement(By element) {
        waitUntilElementIsClickable(driver.findElement(element));
        return driver.findElement(element);
    }

    public WebElement getViewableBaseElement(By element) {
        waitUntilElementIsClickable(driver.findElement(element));
        return driver.findElement(element);
    }

    public WebElement getBaseElement(By element) {
        return driver.findElement(element);
    }

    public void hoverOverElement(WebElement element) {
//        waitUntilElementIsVisible(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
