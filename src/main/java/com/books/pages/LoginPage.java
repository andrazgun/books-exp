package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.books.utils.BrowserUtils;

public class LoginPage extends BasePage implements Page {

    private final String expectedPageUrl = "https://www.books-express.ro/login";
    private final String expectedPageTitle = "Intră în cont!";
    private final By emailField = By.cssSelector("[id='username']");
    private final By emailButton = By.cssSelector("[id='email-button']");
    private final By passwordField = By.cssSelector("[id='password']");
    private final By loginButton = By.cssSelector("[id='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void insertEmail(String email) {
        waitUntilElementIsClickable(getBaseElement(emailField));
        getBaseElement(emailField).clear();
        getBaseElement(emailField).sendKeys(email);
    }

    public void insertPassword(String email) {
        waitUntilElementIsClickable(getBaseElement(passwordField));
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
    public void openPage() { super.openPage(this.expectedPageUrl); }

    public WebElement getLoginButtonElement() {
        return getBaseElement(loginButton);
    }

}
