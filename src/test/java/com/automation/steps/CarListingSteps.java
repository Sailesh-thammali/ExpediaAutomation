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

    @Then("print car rental details")
    public void printCarRentalDetails() {
        carListingPage.printLocationDetails();
        carListingPage.printCarDetails();

    }

    @Then("verify user is on car review page")
    public void verifyUserIsOnCarReviewPage() {
        Assert.assertTrue(carListingPage.isCarReviewPageDisplayed());
    }

    @When("user selects the number of passengers {string}")
    public void userSelectsTheNumberOfPassengers(String arg0) {
        carListingPage.clickOnPassengersBox();
    }

    @Then("verify user gets all cars as selected number of passengers")
    public void verifyUserGetsAllCarsAsSelectedNumberOfPassengers() {
        Assert.assertTrue(carListingPage.isNoOfPassengersDisplayed());
    }

    @When("user clicks on price sort by low to high")
    public void userClicksOnPriceSortByLowToHigh() {
        carListingPage.clickOnSortLowToHighOption();
    }

    @Then("verify user can get car prices in low to high")
    public void verifyUserCanGetCarPricesInLowToHigh() {
        Assert.assertTrue(carListingPage.isPriceLowToHigh());
    }
}
