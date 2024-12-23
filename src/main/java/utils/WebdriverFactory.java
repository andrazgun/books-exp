package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Arrays;

import static com.books.pages.BasePage.driver;

public class WebdriverFactory {

    private static final ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if (driverInstance.get() == null) {
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("start-maximized");
            options.addArguments("incognito");

            driverInstance.set(new ChromeDriver(options));
        }
        return driverInstance.get();
    }

    public static void quitDriver() {
        if (driverInstance.get() != null) {
            driverInstance.get().quit();
            driverInstance.remove();
        }
    }

}
