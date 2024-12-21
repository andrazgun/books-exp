package com.books.pages;

import utils.BrowserUtils;

public interface Page {

    void openPage();

    void closePage();

    void reloadPage();

    String getActualPageURL();

    String getActualPageTitle();

}
