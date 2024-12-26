package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final String expectedPageUrl = "https://www.books-express.ro/login";
    private final String expectedPageTitle = "Intră în cont!";
    private final By emailField = By.cssSelector("[id='username']");
    private final By emailButton = By.cssSelector("[id='email-button']");
    private final By passwordField = By.cssSelector("[id='password']");
    private final By loginButton = By.cssSelector("[id='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        super.openPage(expectedPageUrl);
    }

    public void enterEmail(String email) {
        waitUntilElementIsClickable(getBaseElement(emailField));
        getBaseElement(emailField).clear();
        getBaseElement(emailField).sendKeys(email);
    }

    public void enterPassword(String email) {
        waitUntilElementIsClickable(getBaseElement(passwordField));
        getBaseElement(passwordField).clear();
        getBaseElement(passwordField).sendKeys(email);
    }

    @Override
    public String getExpectedPageTitle() {
        return this.expectedPageTitle;
    }

    @Override
    public String getExpectedPageUrl() {
        return this.expectedPageUrl;
    }

    public void clickEmailButton() {
        getBaseElement(emailButton).click();
    }

    public void clickLoginButton() {
        getBaseElement(loginButton).click();
    }

    public WebElement getLoginButtonElement() {
        return getBaseElement(loginButton);
    }
}