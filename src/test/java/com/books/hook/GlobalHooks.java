package com.books.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import com.books.utils.WebdriverFactory;


public class GlobalHooks {

    private WebDriver driver;

    @Before
    public void beforeAll() {
        // Initialize WebDriver before each scenario
        if (driver == null) {
            driver = WebdriverFactory.getDriver();
            System.out.println("WebDriver initialized.");
        }
    }

    @After
    public void after() {
        if (driver != null) {
            WebdriverFactory.quitDriver();
        }
        System.out.println("WebDriver quit.");
    }
}
