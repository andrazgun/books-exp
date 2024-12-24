package com.books.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import com.books.utils.WebDriverFactory;


public class GlobalHooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            driver = WebDriverFactory.getDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            System.out.println("WebDriver initialized.");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            WebDriverFactory.closeDriver();
        }
        System.out.println("WebDriver quit.");
    }
}
