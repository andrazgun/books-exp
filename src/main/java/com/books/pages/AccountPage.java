package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.books.utils.BrowserUtils;

public class AccountPage extends BasePage implements Page {

    private final String expectedPageUrl = "https://www.books-express.ro/user/details";
    private final By personalDetailsElement = By.cssSelector("[id='profile']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        super.openPage(this.expectedPageUrl);
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
