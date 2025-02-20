package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CarListingSteps extends BaseSteps {
    @Then("verify user is on car listing page")
    public void verifyUserIsOnCarListingPage() {
        Assert.assertTrue(carListingPage.isCarListingPageDisplayed());
    }

    @When("user click on first car")
    public void userClickOnFirstCar() {
        carListingPage.clickOnFirstCar();
    }

    @And("print car rental details")
    public void printCarRentalDetails() {
        carListingPage.printCarDetails();
    }
}
