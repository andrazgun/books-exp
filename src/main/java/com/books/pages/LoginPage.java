package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        BrowserUtils.waitUntilElementIsClickable(getBaseElement(emailField));
        getBaseElement(emailField).clear();
        getBaseElement(emailField).sendKeys(email);
    }

    public void insertPassword(String email) {
        BrowserUtils.waitUntilElementIsClickable(getBaseElement(passwordField));
        getBaseElement(passwordField).clear();
        getBaseElement(passwordField).sendKeys(email);
    }

    public String getExpectedPageTitle() {
        return expectedPageTitle;
    }

    @Override
    public String getExpectedPageUrl() {
        return expectedPageUrl;
    }

    public void clickEmailButton() {
        getBaseElement(emailButton).click();
    }

    public void clickLoginButton() {
        getBaseElement(loginButton).click();
    }

    @Override
    public void openPage() {
        driver.get(expectedPageUrl);
    }

    public WebElement getLoginButtonElement() {
        return getBaseElement(loginButton);
    }

}
