package com.books.utils;

import com.books.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectFactory {

    private final WebDriver driver;
    public WebDriverWait wait;

    public PageObjectFactory(WebDriver driver) {
        this.driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public <T> T createPage(Class<T> pageClass) {
        try {
            if (BasePage.class.isAssignableFrom(pageClass) && !java.lang.reflect.Modifier.isAbstract(pageClass.getModifiers())) {
                return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
            } else {
                throw new IllegalArgumentException("Class " + pageClass.getSimpleName() + " is abstract or not a subclass of BasePage.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page object: " + pageClass.getSimpleName(), e);
        }
    }
}
