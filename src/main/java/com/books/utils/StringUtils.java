package com.books.utils;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class StringUtils {
    public static String removeWhitespaces(String str) {
        return str.replaceAll("\\s", EMPTY);
    }

    public static String removePunctuationSigns(String str) {
        return str.replaceAll("[^a-zA-Z\\s]", "").trim();
    }
}