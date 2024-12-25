package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final String expectedPageUrl = "https://www.books-express.ro/";
    private final By searchField = By.cssSelector("[id='search']");
    private final By searchButton = By.cssSelector("[class='button special search right']");
    private final By productsDropdown = By.cssSelector("[id='products']");
    private final By categoryList = By.cssSelector("[class='category-menu']");
    private final By cookieBotDialog = By.cssSelector("[id='CybotCookiebotDialog']");
    private final By acceptAllCookiesButton = By.cssSelector("[id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        super.openPage(expectedPageUrl);
    }

    public void searchForBook(String bookName) {
        getBaseElement(searchField).sendKeys(bookName);
        getBaseElement(searchButton).click();
    }

    @Override
    public String getExpectedPageUrl() {
        return this.expectedPageUrl;
    }

    public void hoverOverProductsDropdown() {
        super.hoverOverElement(getBaseElement(productsDropdown));
    }

    public void clickOnProductCategory(String elementName) {
        getElementFromElementsCategory(elementName, categoryList)
                .click();
    }

    public void clickAcceptAllCookiesButton() {
        try {
            if (getCookiesDialogElement().isDisplayed()) {
                getClickableBaseElement(acceptAllCookiesButton).click();
            }
        } catch (NoSuchElementException ignored) {
        }
    }

    public WebElement getClickableCookiesDialogElement() {
        return getClickableBaseElement(cookieBotDialog);
    }

    public WebElement getCookiesDialogElement() {
        return getBaseElement(cookieBotDialog);
    }
}
