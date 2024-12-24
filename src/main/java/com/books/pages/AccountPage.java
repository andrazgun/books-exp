package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {

    private final String expectedPageUrl = "https://www.books-express.ro/user/details";
    private final By personalDetailsElement = By.cssSelector("[id='profile']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        super.openPage(expectedPageUrl);
    }

    @Override
    public String getExpectedPageUrl() {
        return super.getExpectedPageUrl();
    }

    @Override
    public String getActualPageURL() {
        return super.getActualPageURL();
    }

    @Override
    public String getActualPageTitle() {
        return super.getActualPageTitle();
    }

    public WebElement getViewablePersonalDetailsElement() {
        waitUntilElementIsVisible(driver.findElement(personalDetailsElement));
        return getBaseElement(personalDetailsElement);
    }
}
