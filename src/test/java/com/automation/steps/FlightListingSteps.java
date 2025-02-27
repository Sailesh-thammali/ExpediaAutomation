package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightListingSteps extends BaseSteps {
    @Then("verify user is on flight listing page")
    public void verifyUserIsOnFlightListingPage() {
        Assert.assertTrue(flightListingPage.isFlightListingPageDisplayed());
    }

    @When("user clicks on first flight")
    public void userClicksOnFirstFlight() {
        flightListingPage.clickOnFirstFlight();
    }


    @When("user clicks on price high to low")
    public void userClicksOnPriceHighToLow() {
        flightListingPage.clickOnSortHighToLowOption();
    }

    @Then("verify user can get prices in high to low")
    public void verifyUserCanGetPricesInHighToLow() {
        Assert.assertTrue(flightListingPage.isPriceHighToLow());
    }

    @When("user clicks on price low to high")
    public void userClicksOnPriceLowToHigh() {
        flightListingPage.clickOnSortLowToHighOption();
    }

    @Then("verify user can get prices in low to high")
    public void verifyUserCanGetPricesInLowToHigh() {
        Assert.assertTrue(flightListingPage.isPriceLowToHigh());
    }

    @When("user selects the flight company {string}")
    public void userSelectsTheFlightCompany(String arg0) {
        flightListingPage.clickOnAirIndiaFilter();

    }

    @Then("verify user can get all flights as selected company")
    public void verifyUserCanGetAllFlightsAsSelectedCompany() {
        Assert.assertTrue(flightListingPage.isSelectedFlightShown(ConfigReader.getConfigValue("flight.company")));

    }

    @When("user selects the flight stops {string}")
    public void userSelectsTheFlightStops(String arg0) {
        flightListingPage.clickOnDirectFilter();

    }

    @Then("verify user can get all flights as selected stops")
    public void verifyUserCanGetAllFlightsAsSelectedStops() {
        Assert.assertTrue(flightListingPage.isSelectedStopsShown(ConfigReader.getConfigValue("flight.stops")));
    }
}
