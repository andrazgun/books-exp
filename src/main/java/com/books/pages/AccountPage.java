package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {

    private final String expectedPageUrl = "https://www.books-express.ro/user/details";
    private final By personalDetailsElement = By.cssSelector("[id='profile']");
    private final By sectionListElement = By.cssSelector("[class='left'] li");


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        super.openPage(expectedPageUrl);
    }

    @Override
    public String getExpectedUrl() {
        return this.expectedPageUrl;
    }

    public WebElement getViewablePersonalDetailsElement() {
        return getBaseWebElement(personalDetailsElement);
    }

    public String getSectionListText(String inputText) {
        waitForElementToBeVisible(sectionListElement);
        printWebElementTexts(sectionListElement);
        return findElementByName(sectionListElement, inputText, 5).getText();
    }
}