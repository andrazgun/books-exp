package com.books.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import com.books.utils.WebDriverFactory;

import java.io.IOException;

public class GlobalHooks {

    private WebDriver driver;

    @Before
    public void beforeAll() throws IOException {
        // Initialize WebDriver before each scenario
        if (driver == null) {
            driver = WebDriverFactory.getDriver();
            System.out.println("WebDriver initialized.");
        }
    }

    @After
    public void after() {
        if (driver != null) {
            WebDriverFactory.quitDriver();
        }
        System.out.println("WebDriver quit.");
    }
}
