package com.automation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightListingSteps extends BaseSteps{
    @Then("verify user is on flight listing page")
    public void verifyUserIsOnFlightListingPage() {
        flightListingPage.isFlightListingPageDisplayed();
    }

    @When("user clicks on first flight")
    public void userClicksOnFirstFlight() {
        flightListingPage.clickOnFirstFlight();
    }
}
