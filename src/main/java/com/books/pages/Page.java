package com.books.pages;

public interface Page {

    void openPage();

    void closePage();

    void refreshPage();

    String getActualPageURL();

    String getActualPageTitle();

}
