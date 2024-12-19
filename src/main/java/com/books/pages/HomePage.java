package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Locators
    private By searchBox = By.cssSelector("[id='search']");
    private By searchButton = By.cssSelector("[class='button special search right']");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void searchForBook(String bookName) {
        driver.findElement(searchBox).sendKeys(bookName);
        driver.findElement(searchButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
