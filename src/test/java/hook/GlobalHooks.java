package hook;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;


public class GlobalHooks {

    private WebDriver driver;

    @Before
    public void beforeAll() {
        // Initialize WebDriver before each scenario
        if (driver == null) {
            driver = WebDriverManager.chromedriver().create();
            System.out.println("WebDriver initialized.");
        }
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
            driver = null; // Optional: Prevent reuse of the driver reference.
        }
        System.out.println("WebDriver quit.");
    }
}
