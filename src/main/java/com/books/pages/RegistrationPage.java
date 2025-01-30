package com.books.pages;

import com.books.utils.JavaScriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class RegistrationPage extends BasePage {

    private final String expectedPageUrl = "https://www.books-express.ro/register";
    private final By emailField = By.cssSelector("[id='email']");
    private final By firstNameField = By.cssSelector("[id='first_name']");
    private final By lastNameField = By.cssSelector("[id='last_name']");
    private final By passwordField = By.cssSelector("[id='password']");
    private final By passwordConfirmField = By.cssSelector("[id='confirm']");
    private final By submitButton = By.cssSelector("[id='submit']");
    private final By emailError = By.cssSelector("[data-for='email']");
    private final By firstNameError = By.cssSelector("[data-for='first_name']");
    private final By lastNameError = By.cssSelector("[data-for='last_name']");
    private final By passwordError = By.cssSelector("[data-for='password']");
    private final By passwordConfirmError = By.cssSelector("[data-for='confirm']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        super.openPage(expectedPageUrl);
    }

    @Override
    public String getExpectedUrl() {
        return this.expectedPageUrl;
    }

    public void enterEmail(String email) {
        enterText(email, emailField);
    }

    public void enterPassword(String password) {
        enterText(password, passwordField);
    }

    public void enterFirstName(String firstName) {
        enterText(firstName, firstNameField);
    }

    public void enterLastName(String lastName) {
        enterText(lastName, lastNameField);
    }

    public void enterPasswordConfirm(String passwordConfirm) {
        enterText(passwordConfirm, passwordConfirmField);
    }

    public void clickRegisterButton() throws IOException {
        JavaScriptUtils.scrollScreenDown();
        clickButton(submitButton);
    }

    public WebElement getEmailErrorElement() {
        waitForElementToBeVisible(emailError);
        return getBaseWebElement(emailError);
    }

    private record FieldHandler(Supplier<String> errorMessageSupplier, Consumer<String> fieldFiller) {}

    private final Map<String, FieldHandler> fieldHandlers = Map.of(
            "Email", new FieldHandler(this::getEmailErrorMessage, this::enterEmail),
            "First Name", new FieldHandler(this::getFirstNameErrorMessage, this::enterFirstName),
            "Last Name", new FieldHandler(this::getLastNameErrorMessage, this::enterLastName),
            "Password", new FieldHandler(this::getPasswordErrorMessage, this::enterPassword),
            "Password Confirm", new FieldHandler(this::getPasswordAgainErrorMessage, this::enterPasswordConfirm)
    );

    public String getErrorMessageForField(String field) {
        FieldHandler handler = fieldHandlers.get(field);
        if (handler == null) {
            throw new IllegalArgumentException("Unexpected field: " + field);
        }
        return handler.errorMessageSupplier().get(); // If using record
    }

    public void fillField(String field, String value) {
        if (value == null || "[empty]".equals(value)) {
            value = "";
        }
        FieldHandler handler = fieldHandlers.get(field);
        if (handler == null) {
            throw new IllegalArgumentException("Unexpected field: " + field);
        }
        handler.fieldFiller().accept(value); // If using record
    }

    public String getEmailErrorMessage() {
        return getEmailErrorElement().getText();
    }

    public String getFirstNameErrorMessage() {
        return getBaseWebElement(firstNameError).getText();
    }

    public String getLastNameErrorMessage() {
        return getBaseWebElement(lastNameError).getText();
    }

    public String getPasswordErrorMessage() {
        return getBaseWebElement(passwordError).getText();
    }

    public String getPasswordAgainErrorMessage() {
        return getBaseWebElement(passwordConfirmError).getText();
    }
}