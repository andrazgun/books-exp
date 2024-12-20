package com.books.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.WebdriverFactory.getDriver;

public class BasePage implements Page {

    private String url;
    public static WebDriver driver = getDriver("chrome");
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Override
    public void openPage() {
        driver.get(url);
    }



    @Override
    public void closePage() {
        driver.quit();

    }

    @Override
    public void reloadPage() {
        driver.navigate().refresh();
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }
}
