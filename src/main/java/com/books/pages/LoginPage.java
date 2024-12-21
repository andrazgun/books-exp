package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;

public class LoginPage extends BasePage implements Page {

    private String expectedPageUrl = "https://www.books-express.ro/login";
    private String expectedPageTitle = "Intră în cont!";
    private By emailField = By.cssSelector("[id='username']");
    private By emailButton = By.cssSelector("[id='email-button']");
    private By passwordField = By.cssSelector("[id='password']");
    private By loginButton = By.cssSelector("[id='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void insertEmail(String email) {
        BrowserUtils.waitUntilElementIsClickable(driver.findElement(emailField));
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void insertPassword(String email) {
        BrowserUtils.waitUntilElementIsClickable(driver.findElement(passwordField));
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(email);
    }


    public String getExpectedPageTitle() {
        return expectedPageTitle;
    }

    @Override
    public String getExpectedPageUrl() {
        return expectedPageUrl;
    }

    public void clickEmailButton() {
        driver.findElement(emailButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
