package com.books.hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.books.utils.WebDriverInstanceFactory;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GlobalHooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            driver = WebDriverInstanceFactory.getDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            System.out.println("WebDriver initialized for thread: " + Thread.currentThread().getName());
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            WebDriverInstanceFactory.closeDriver();
            driver = null;
        }
        System.out.println("WebDriver quit for thread: " + Thread.currentThread().getName());
    }

    @AfterStep
    public void attachScreenshotOnFailure(Scenario scenario) {
        if (driver != null && scenario.isFailed()) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = String.valueOf(System.currentTimeMillis());
            String screenshotPath = System.getProperty("user.dir") + "/target/screenshots/" + scenario.getName() + "_" + timestamp + ".png";

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
}
