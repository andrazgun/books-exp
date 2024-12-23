package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserUtils;

public class AccountPage extends BasePage implements Page {

    private String expectedPageUrl = "https://www.books-express.ro/user/details";
    private By personalDetailsElement = By.cssSelector("[id='profile']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        driver.get(expectedPageUrl);
    }

    @Override
    public String getExpectedPageUrl() {
        return expectedPageUrl;
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
        BrowserUtils.waitUntilElementIsVisible(driver.findElement(personalDetailsElement));
        return getBaseElement(personalDetailsElement);
    }
}
