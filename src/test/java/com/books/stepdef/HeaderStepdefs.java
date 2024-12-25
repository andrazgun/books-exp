package com.books.stepdef;
import com.books.utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class HeaderStepdefs {
    TestContextSetup testContextSetup;

    public HeaderStepdefs(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

        @When("I hover over Account icon on Header")
        public void iHoverOverAccountIcon () {
            testContextSetup.headerNav.hoverOverAccountIcon();
        }

        @And("I click Login button on Header")
        public void iClickLoginButton () {
            testContextSetup.headerNav.clickLoginButton();
        }

        @Then("I should see {string} on the Header")
        public void iShouldSeePersonalDetailsOnTheHeader (String actualText){
            testContextSetup.headerNav.hoverOverAccountIcon();
            String expectedText = testContextSetup.headerNav.getPersonalDetailsText();
            assertThat(expectedText).as("Expected text contains %s", expectedText)
                    .contains(actualText);
        }

        @And("I click Detalii Personale button on Header")
        public void iClickButtonOnHeader () {
            testContextSetup.headerNav.clickUserDetailsButton();
        }
    }