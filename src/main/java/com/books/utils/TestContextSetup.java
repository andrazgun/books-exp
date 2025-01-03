package com.books.utils;

import com.books.pages.*;
import com.books.session.ScenarioSession;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {

    public WebDriver driver = WebDriverInstanceFactory.getDriver();
    public HeaderNav headerNav;
    public HomePage homePage;
    public LoginPage loginPage;
    public AccountPage accountPage;
    public CartPage cartPage;
    public PLPPage plpPage;
    public PDPPage pdpPage;
    public WishlistPage wishlistPage;
    public RegistrationPage registrationPage;
    public Search search;
    public SubNav subNav;
    public static ScenarioSession scenarioSession;

    public TestContextSetup() {
        this.headerNav = new HeaderNav(driver);
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.accountPage = new AccountPage(driver);
        this.cartPage = new CartPage(driver);
        this.plpPage = new PLPPage(driver);
        this.pdpPage = new PDPPage(driver);
        this.wishlistPage = new WishlistPage(driver);
        this.registrationPage = new RegistrationPage(driver);
        this.search = new Search(driver);
        this.subNav = new SubNav(driver);
        scenarioSession = new ScenarioSession();
    }
}