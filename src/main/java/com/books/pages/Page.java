package com.books.pages;

public interface Page {

    void openPage();

    void closePage();

    void reloadPage();

    String getActualPageURL();

    String getActualPageTitle();

}
