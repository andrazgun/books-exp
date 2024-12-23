package com.books.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage implements Page {

    private final String expectedPageUrl = "https://www.books-express.ro/";
    private final By searchField = By.cssSelector("[id='search']");
    private final By searchButton = By.cssSelector("[class='button special search right']");
    private final By productsDropdown = By.cssSelector("[id='products']");
    private final By categoryList = By.cssSelector("[class='category-menu']");
    private final By cookieBotDialog = By.cssSelector("[id='CybotCookiebotDialog']");
    private final By acceptAllCookiesButton = By.cssSelector("[id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");

    public HomePage(WebDriver driver) { super(driver); }

    public void searchForBook(String bookName) {
        getBaseElement(searchField).sendKeys(bookName);
        getBaseElement(searchButton).click();
    }

    @Override
    public String getActualPageTitle() {
        return super.getActualPageTitle();
    }

    @Override
    public String getActualPageURL() {
        return super.getActualPageURL();
    }

    @Override
    public void openPage() {
        super.openPage(this.expectedPageUrl);
    }

    @Override
    public void closePage() {
        super.closePage();
    }

    @Override
    public void refreshPage() {
        super.refreshPage();
    }

    @Override
    public String getExpectedPageUrl() {
        return expectedPageUrl;
    }

    public void hoverOverProductsDropdown() {
        super.hoverOverElement(getBaseElement(productsDropdown));
    }

    public WebElement selectProductCategory(String elementName) {
        List<WebElement> elementsList = driver.findElements(categoryList);
        return elementsList.stream()
                .filter(elem -> elem.getText().equalsIgnoreCase((elementName)))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Category with name '" + elementName + "' not found."));
    }

    public void clickOnProductCategory (String categoryName) {
        selectProductCategory(categoryName).click();
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
