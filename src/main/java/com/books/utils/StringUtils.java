package com.books.utils;

public class StringUtils {

    public static String removePunctuationSigns(String str) {
        return str.replaceAll("[^a-zA-Z\\s]", "").trim();
    }
}