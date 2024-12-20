package com.books.pages;

import com.books.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage implements Page {
    private WebDriver driver;

    // Locators
    private By searchBox = By.cssSelector("[id='search']");
    private By searchButton = By.cssSelector("[class='button special search right']");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void searchForBook(String bookName) {
        driver.findElement(searchBox).sendKeys(bookName);
        driver.findElement(searchButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public void openPage() {
        driver.get("https://www.books-express.ro/");
    }
}
