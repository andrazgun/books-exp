package stepdef;

import com.books.pages.HomePage;
import io.cucumber.java.en.Given;

import static com.books.pages.BasePage.driver;

public class ShoppingCartStepdefs {

    HomePage homePage = new HomePage(driver);

    @Given("I hover over the {string} dropdown")
    public void iHoverOverTheDropdown(String text) {
        homePage.hoverOverProductsDropdown();
    }
}
