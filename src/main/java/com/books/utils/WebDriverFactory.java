package com.books.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverFactory {

//    private static WebDriver driver;
//
//        public static WebDriver getDriver() {
//        if (driver == null) {
//            try {
//                Properties properties = new Properties();
//                properties.load(new FileInputStream("src/test/resources/global.properties"));
//                String browser = properties.getProperty("browser");
//
//                switch (browser.toLowerCase()) {
//                    case "chrome":
//                        ChromeOptions options = new ChromeOptions();
//                        options.addArguments("incognito");
//                        options.addArguments("--headless");
//                        driver = new ChromeDriver(options);
//                        break;
//                    case "firefox":
//                        FirefoxOptions options1 = new FirefoxOptions();
//                        options1.addArguments("-private");
//                        options1.addArguments("--headless");
//                        WebDriverManager.firefoxdriver().setup();
//                        driver = new FirefoxDriver(options1);
//                        break;
//                    default:
//                        throw new IllegalArgumentException("Unsupported browser: " + browser);
//                }
//                System.out.println("\"" + browser + "\"" + " browser selected");
//            } catch (IOException e) {
//                throw new RuntimeException("Failed to read browser configuration", e);
//            }
//        }
//        return driver;
//    }
//
//    public static void closeDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }

// ThreadLocal variable to hold WebDriver for each thread (i.e., each test in parallel)
private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("src/test/resources/global.properties"));
                String browser = properties.getProperty("browser");

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
                        WebDriverManager.firefoxdriver().setup();
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