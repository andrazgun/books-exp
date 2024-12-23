package com.books.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.books.pages.PageObjectManager.driver;

public class ScreenshotUtils {
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Specify the location to save the screenshot
            Files.copy(screenshot.toPath(), new File(Constants.SCREENSHOT_DIRECTORY + screenshotName + ".png").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String takeScreenshot(String testName) {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotPath = Constants.SCREENSHOT_DIRECTORY + "screenshot_" + testName + " " + timestamp + ".png";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile,
                    new File(screenshotPath));
        } catch (IOException e) {
            System.out.println("Screenshot capture failed.");
        }
        return screenshotPath;
    }
}
