package com.books.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        switch (prop.getProperty("browser").toLowerCase()) {
            case "chrome":
                if (DRIVER.get() == null) {
                    ChromeOptions options = new ChromeOptions();
                    options.setAcceptInsecureCerts(true);
                    options.addArguments("start-maximized");
                    options.addArguments("incognito");

                    DRIVER.set(new ChromeDriver(options));
                }
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                DRIVER.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                DRIVER.set(new EdgeDriver());
                break;
            case "safari":
                DRIVER.set(new SafariDriver()); // SafariDriver doesn't require WebDriverManager
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + prop.getProperty("browser").toLowerCase() + "\" not supported.");
        }
        return DRIVER.get();

    }

    public static void quitDriver() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
