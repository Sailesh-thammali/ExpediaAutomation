package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightSearchSteps extends BaseSteps{
    @Then("verify user is on flight search page")
    public void verifyUserIsOnFlightSearchPage() {
        Assert.assertTrue(flightSearchPage.isFlightSearchPageDisplayed());
    }

    @When("user clicks on one-way option")
    public void userClicksOnOneWayOption() {
        flightSearchPage.clickOnOnewayOption();

    }


    @And("enters {string},{string},{string} and {string}")
    public void entersAnd(String arg0, String arg1, String arg2, String arg3)  {
        flightSearchPage.enterFromCity(ConfigReader.getConfigValue("flight.from.city"));
        flightSearchPage.enterToCity(ConfigReader.getConfigValue("flight.to.city"));
        flightSearchPage.enterDate(ConfigReader.getConfigValue("date"));
        flightSearchPage.enterNoOfTravellers(ConfigReader.getConfigValue("flight.travellers"));
    }

    @And("clicks on search button")
    public void clicksOnSearchButton() {
        flightSearchPage.clickOnSearchButton();
    }



}
