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
        enterText(email, emailField);
    }

    public void enterPassword(String password) {
        enterText(password, passwordField);
    }

    @Override
    public String getExpectedTitle() {
        return this.expectedPageTitle;
    }

    @Override
    public String getExpectedUrl() {
        return this.expectedPageUrl;
    }

    public void clickEmailButton() {
        waitForElementToBeClickable(getBaseWebElement(emailButton));
        clickButton(emailButton);
    }

    public void clickLoginButton() {
        waitForElementToBeClickable(getBaseWebElement(loginButton));
        getBaseWebElement(loginButton).click();
    }

    public WebElement getLoginButtonElement() {
        return getBaseWebElement(loginButton);
    }
}