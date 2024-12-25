//package com.books.utils;
//
//import com.books.pages.BasePage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.picocontainer.MutablePicoContainer;
//
//import java.time.Duration;
//
//public class PageObjectFactory {
//
//    private final WebDriver driver;
//    public WebDriverWait wait;
//    private final MutablePicoContainer container;
//
//    public PageObjectFactory(WebDriver driver, MutablePicoContainer container) {
//        this.driver = WebDriverFactory.getDriver();
//        this.container = PicoContainerFactory.createContainer(driver);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//    }
//
//    public <T> T createPage(Class<T> pageClass) {
//        return container.getComponent(pageClass);
//    }
//    public WebDriver getDriver() {
//        return driver;
//    }
//
//    public WebDriverWait getWait() {
//        return wait;
//    }
//}
