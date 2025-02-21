package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CarSearchSteps extends BaseSteps {
    @Then("verify user is on car search page")
    public void verifyUserIsOnCarSearchPage() {
        Assert.assertTrue(carSearchPage.isCarSearchPageDisplayed());

    }

    @When("user enters {string},{string},{string},{string},{string} and {string}")
    public void userEntersAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5)  {
        carSearchPage.enterFromCity(ConfigReader.getConfigValue("car.from.city"));
        carSearchPage.enterToCity(ConfigReader.getConfigValue("car.to.city"));
        carSearchPage.enterFromDate(ConfigReader.getConfigValue("car.from.date"));
        carSearchPage.enterToDate(ConfigReader.getConfigValue("car.to.date"));
        carSearchPage.enterPickupAndDropOffTime(ConfigReader.getConfigValue("car.pickup.time"), ConfigReader.getConfigValue("car.dropOff.time"));
    }

    @And("user clicks on search button")
    public void userClicksOnSearchButton() {
        carSearchPage.clickOnSearchButton();

    }




}
