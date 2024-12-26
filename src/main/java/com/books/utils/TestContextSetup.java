package com.books.utils;

import com.books.pages.*;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {

    public WebDriver driver = WebDriverFactory.getDriver();
    public HeaderNav headerNav;
    public HomePage homePage;
    public LoginPage loginPage;
    public AccountPage accountPage;
    public CartPage cartPage;
    public PLPPage plpPage;
    public WishlistPage wishlistPage;
    public RegistrationPage registrationPage;
    public Search search;

    public TestContextSetup() {
        this.headerNav = new HeaderNav(driver);
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.accountPage = new AccountPage(driver);
        this.cartPage = new CartPage(driver);
        this.plpPage = new PLPPage(driver);
        this.wishlistPage = new WishlistPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.search = new Search(driver);
    }
}