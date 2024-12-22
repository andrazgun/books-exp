package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage implements Page {

    private String expectedPageUrl = "https://www.books-express.ro/";
    private By searchField = By.cssSelector("[id='search']");
    private By searchButton = By.cssSelector("[class='button special search right']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForBook(String bookName) {
        driver.findElement(searchField).sendKeys(bookName);
        driver.findElement(searchButton).click();
    }

    @Override
    public String getActualPageTitle() {
        return super.getActualPageTitle();
    }

    @Override
    public String getActualPageURL() {
        return driver.getCurrentUrl();
    }

    @Override
    public void openPage() {
        driver.get(expectedPageUrl);
    }

    @Override
    public void closePage() {
        driver.quit();
    }

    @Override
    public void reloadPage() {
        driver.navigate().refresh();
    }

    @Override
    public String getExpectedPageUrl() {
        return expectedPageUrl;
    }

    public WebElement getClickableCookiesDialogElement() {
        return super.getClickableCookiesDialogElement();
    }

    public void clickAcceptAllCookiesButton() {
        super.clickAcceptAllCookiesButton();
    }
}
