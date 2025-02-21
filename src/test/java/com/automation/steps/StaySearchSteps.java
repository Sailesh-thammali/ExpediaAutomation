package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StaySearchSteps extends BaseSteps{

    @Then("verify user is on stay search page")
    public void verifyUserIsOnStaySearchPage() {
        Assert.assertTrue(staySearchPage.isStaySearchPageDisplayed());
    }

    @When("user enters {string},{string},{string} and {string}")
    public void userEntersAnd(String arg0, String arg1, String arg2, String arg3) {
        staySearchPage.enterCity(ConfigReader.getConfigValue("stay.city"));
        staySearchPage.enterFromDate(ConfigReader.getConfigValue("stay.from.date"));
        staySearchPage.enterToDate(ConfigReader.getConfigValue("stay.to.date"));
        staySearchPage.enterNoOfTravellers(ConfigReader.getConfigValue("stay.travellers"));
    }
}
