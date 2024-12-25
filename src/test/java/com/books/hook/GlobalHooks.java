package com.books.hook;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.books.utils.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class GlobalHooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            driver = WebDriverFactory.getDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            System.out.println("WebDriver initialized.");
        }
    }

    @AfterStep
    public void attachScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot as a file
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Save the screenshot in the target/screenshots directory
            String screenshotPath = System.getProperty("user.dir") + "/target/screenshots/" + scenario.getName() + ".png";

            try {
                // Ensure the directory exists
                Files.createDirectories(new File(screenshotPath).getParentFile().toPath());
                // Save the screenshot file
                Files.copy(screenshotFile.toPath(), new File(screenshotPath).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Attach the screenshot to the Cucumber report
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            WebDriverFactory.closeDriver();
        }
        System.out.println("WebDriver quit.");
    }
}
