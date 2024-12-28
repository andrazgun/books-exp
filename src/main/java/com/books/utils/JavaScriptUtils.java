package com.books.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class JavaScriptUtils {

    public static void scrollUp() throws IOException {
        executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }

    public static void scrollScreenUp() throws IOException {
        executeScript("window.scrollBy(0, -document.documentElement.clientHeight)");
    }

    public static void scrollScreenDown() throws IOException {
        executeScript("window.scrollBy(0, document.documentElement.clientHeight)");
    }

    public static void scrollIntoView(WebElement element) throws IOException {
        executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private static JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) WebDriverInstanceFactory.getDriver();
    }

    public static Object executeScript(final String script, final Object... elements) {
        return getJavascriptExecutor().executeScript(script, elements);
    }
}