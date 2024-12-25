package com.books.stepdef;

import com.books.utils.TestContextSetup;
import io.cucumber.java.en.Given;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationStepdefs {
    TestContextSetup testContextSetup;

    public RegistrationStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("I navigate to Registration page")
    public void iNavigateToHomepage() {
        testContextSetup.registrationPage.openPage();
        assertThat(testContextSetup.registrationPage.getActualPageUrl()).as("Expected Page URL to be %s", testContextSetup.homePage.getActualPageUrl())
                .contains(testContextSetup.registrationPage.getActualPageUrl());
    }
}
