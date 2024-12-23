package com.books.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    public static Object executeScript(final String script, final Object... elements) {
        return getJavascriptExecutor().executeScript(script, elements);
    }

    public static void scrollUp() {
        executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }

    public static void scrollScreenUp() {
        executeScript("window.scrollBy(0, -document.documentElement.clientHeight)");
    }

    public static void scrollScreenDown() {
        executeScript("window.scrollBy(0, document.documentElement.clientHeight)");
    }

    public static void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private static JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) WebDriverFactory.getDriver();
    }

}
