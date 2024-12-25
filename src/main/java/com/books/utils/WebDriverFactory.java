package com.books.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("src/test/resources/global.properties"));
                String browser = properties.getProperty("browser");
//                String browser = System.getProperty("browser", "chrome");

                switch (browser.toLowerCase()) {
                    case "chrome":
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("incognito");
                        options.addArguments("--headless");
                        driver = new ChromeDriver(options);
                        break;
                    case "firefox":
                        FirefoxOptions options1 = new FirefoxOptions();
                        options1.addArguments("-private");
                        options1.addArguments("--headless");
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver(options1);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
                System.out.println("Starting " + browser + " browser");
            } catch (IOException e) {
                throw new RuntimeException("Failed to read browser configuration", e);
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
