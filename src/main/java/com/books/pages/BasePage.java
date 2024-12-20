package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.BrowserUtils.waitUntilElementIsClickable;
import static utils.WebdriverFactory.getDriver;

public class BasePage implements Page {

    private String url;
    public static WebDriver driver = getDriver("chrome");
    public WebDriverWait wait;
    private final By acceptCookiesButton = By.cssSelector("[id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Override
    public void closePage() {
        driver.quit();
    }

    @Override
    public void reloadPage() {
        driver.navigate().refresh();
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

    public WebElement getBaseElement(By element) {
        waitUntilElementIsClickable(driver.findElement(element));
        return driver.findElement(element);
    }

    @Override
    public void openPage() {
        driver.get(url);
        getBaseElement(acceptCookiesButton).click();
    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

}
