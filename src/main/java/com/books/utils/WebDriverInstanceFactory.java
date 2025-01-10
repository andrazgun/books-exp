package com.books.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverInstanceFactory {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("src/test/resources/global.properties"));
                String browser_properties = properties.getProperty("browser");
                String browser_maven = System.getProperty("browser");

                String browser = browser_maven != null ? browser_maven : browser_properties;

                switch (browser.toLowerCase()) {
                    case "chrome":
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("incognito");
//                        options.addArguments("--headless");
                        driverThreadLocal.set(new ChromeDriver(options));
                        break;
                    case "firefox":
                        FirefoxOptions options1 = new FirefoxOptions();
                        options1.addArguments("-private");
                        driverThreadLocal.set(new FirefoxDriver(options1));
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
                System.out.println("\"" + browser + "\" browser selected");
            } catch (IOException e) {
                throw new RuntimeException("Failed to read browser configuration", e);
            }
        }
        driverThreadLocal.get().manage().deleteAllCookies();
        driverThreadLocal.get().manage().window().maximize();
        return driverThreadLocal.get();
    }

    // Close the WebDriver for the current thread
    public static void closeDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}