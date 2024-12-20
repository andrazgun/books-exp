package hook;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;


public class GlobalHooks {
    WebDriver driver;

    @BeforeAll
    public void setUp() {
        // Initialize WebDriver before each scenario
        driver = WebDriverManager.chromedriver().create();
        System.out.println("WebDriver initialized.");
    }

    @After
    public void tearDown() {
        // Quit WebDriver after each scenario
        driver.quit();
        System.out.println("WebDriver quit.");
    }
}
