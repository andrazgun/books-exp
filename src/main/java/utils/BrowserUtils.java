package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.books.pages.BasePage.driver;

public class BrowserUtils {

    public void openPage(String expectedPageUrl) {
        driver.get(expectedPageUrl);
        deleteAllCookies();
        maximizeWindow();
    }

    public void closePage() {
        driver.quit();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public WebElement getBaseElement(By element) {
        return driver.findElement(element);
    }

    public String getActualPageURL() {
        return driver.getCurrentUrl();
    }

    public String getActualPageTitle() {
        return driver.getTitle();
    }

    public static void waitUntilElementIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public WebElement getElementFromList(By element) {
        List<WebElement> elementsList = driver.findElements(element);
        List<WebElement> limitedElementsList = elementsList.stream()
                .limit(5)
                .toList();
        return limitedElementsList.get(0);
    }


}
