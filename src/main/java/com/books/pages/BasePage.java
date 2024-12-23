package com.books.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;
import utils.WebdriverFactory;

import java.time.Duration;
import java.util.List;

import static utils.BrowserUtils.waitUntilElementIsClickable;
import static utils.WebdriverFactory.getDriver;

public class BasePage extends BrowserUtils implements Page {

    public String expectedPageUrl;
    public static WebDriver driver = WebdriverFactory.getDriver();
    public WebDriverWait wait;
    public By cookieBotDialog = By.cssSelector("[id='CybotCookiebotDialog']");
    public By acceptAllCookiesButton = By.cssSelector("[id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Override
    public void openPage() {
        super.openPage(this.expectedPageUrl);
    }

    public void clickAcceptAllCookiesButton() {
        try {
            if (getCookiesDialogElement().isDisplayed()) {
                getClickableBaseElement(acceptAllCookiesButton).click();
            }
        } catch (NoSuchElementException ignored) {
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
        super.closePage();
    }

    @Override
    public void reloadPage() {
        driver.navigate().refresh();
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
