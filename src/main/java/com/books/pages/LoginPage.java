package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private String url = "https://www.books-express.ro/login";
    private By emailField = By.cssSelector("[id='username']");
    private By emailButton = By.cssSelector("[id='email-button']");
    private String expectedPageTitle = "Intră în cont!";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void insertEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public String setExpectedPageTitle() {
        return expectedPageTitle;
    }

    public void clickEmailButton() {
        driver.findElement(emailButton).click();
    }

}
