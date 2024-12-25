package com.books.pages;

import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private final String expectedPageUrl = "https://www.books-express.ro/register";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        super.openPage(expectedPageUrl);
    }
}
