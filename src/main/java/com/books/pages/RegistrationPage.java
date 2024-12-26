package com.books.pages;

import com.books.utils.JavaScriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class RegistrationPage extends BasePage {

    private final String expectedPageUrl = "https://www.books-express.ro/register";
    private final By emailField = By.cssSelector("[id='email']");
    private final By submitButton = By.cssSelector("[id='submit']");
    private final By passwordAgainField = By.cssSelector("[id='confirm']");
    private final By firstNameField = By.cssSelector("[id='first_name']");
    private final By lastNameField = By.cssSelector("[id='last_name']");
    private final By emailError = By.cssSelector("[data-for='email']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        super.openPage(expectedPageUrl);
    }

    public void clickRegisterButton() throws IOException {
        JavaScriptUtils.scrollScreenDown();
        getBaseElement(submitButton).click();
    }

    public void enterPasswordAgain(String password) {
        waitUntilElementIsClickable(getBaseElement(passwordAgainField));
        getBaseElement(passwordAgainField).clear();
        getBaseElement(passwordAgainField).sendKeys(password);
    }

    public void enterEmail(String email) {
        waitUntilElementIsClickable(getBaseElement(emailField));
        getBaseElement(emailField).clear();
        getBaseElement(emailField).sendKeys(email);
    }

    public void enterFirstName(String firstName) {
        waitUntilElementIsClickable(getBaseElement(firstNameField));
        getBaseElement(firstNameField).clear();
        getBaseElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        waitUntilElementIsClickable(getBaseElement(lastNameField));
        getBaseElement(lastNameField).clear();
        getBaseElement(lastNameField).sendKeys(lastName);
    }

    public WebElement getEmailErrorElement() {
        waitUntilElementIsVisible(emailError);
//        waitUntilElementIsVisible(getBaseElement(emailError));
        return getBaseElement(emailError);
    }
}