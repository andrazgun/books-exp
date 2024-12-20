package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage implements Page {

    private String url = "https://www.books-express.ro/";
    private By searchField = By.cssSelector("[id='search']");
    private By searchButton = By.cssSelector("[class='button special search right']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForBook(String bookName) {
        driver.findElement(searchField).sendKeys(bookName);
        driver.findElement(searchButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
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
    public String expectedURL() {
        return url;
    }
}
