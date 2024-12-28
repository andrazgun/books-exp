package com.books.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SeleniumUtils {

    public static WebElement filterElements(List<WebElement> elements, String name, int limit) {
        if (elements == null || name == null || limit <= 0) {
            throw new IllegalArgumentException("Invalid input: elements, name, or limit is null/invalid.");
        }

        // Limit the list of elements
        List<WebElement> limitedElements = elements.stream()
                .limit(limit)
                .toList();

        // Filter for elements matching the target name
        List<WebElement> matchingElements = limitedElements.stream()
                .filter(element -> name.equals(element.getText()))
                .toList();

        if (matchingElements.size() > 1) {
            throw new IllegalArgumentException("More than one WebElement with the same name found: " + name);
        }

        if (matchingElements.isEmpty()) {
            throw new IllegalArgumentException("No WebElement found with the name: " + name);
        }

        return matchingElements.get(0);

    }
    public static WebElement filterElements(WebElement parentElement, String name, int limit) {

        // Create a list of child WebElements from the parent element
        List<WebElement> elements = parentElement.findElements(org.openqa.selenium.By.xpath("*"));

        // Limit the list of elements
        List<WebElement> limitedElements = elements.stream()
                .limit(limit)
                .toList();

        // Filter for elements matching the target name
        List<WebElement> matchingElements = limitedElements.stream()
                .filter(element -> name.equals(element.getText()))
                .toList();

        if (matchingElements.size() > 1) {
            throw new IllegalArgumentException("More than one WebElement with the same name found: " + name);
        }

        if (matchingElements.isEmpty()) {
            throw new IllegalArgumentException("No WebElement found with the name: " + name);
        }

        return matchingElements.get(0);
    }



}
