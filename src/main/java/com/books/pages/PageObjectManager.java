package com.books.pages;

import com.books.utils.BrowserUtils;
import com.books.utils.WebdriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectManager extends BrowserUtils {

    public static WebDriver driver = WebdriverFactory.getDriver();
    public WebDriverWait wait;

    public PageObjectManager(WebDriver driver) {
        PageObjectManager.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public <T> T createPage(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page object: " + pageClass.getSimpleName(), e);
        }
    }

}
