package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StayListingSteps extends BaseSteps {
    @Then("verify user is on stay listing page")
    public void verifyUserIsOnStayListingPage() {
        Assert.assertTrue(stayListingPage.isStayListingPageDisplayed());
    }

    @When("user clicks on first stay")
    public void userClicksOnFirstStay() {
        stayListingPage.clickOnFirstStay();
    }

    @And("clicks on reserve button and pay at property option")
    public void clicksOnReserveButtonAndPayAtPropertyOption() {
        stayListingPage.clickOnReserveButton();
        stayListingPage.clickOnPayAtPropertyOption();
    }

    @Then("verify user is on stay review page")
    public void verifyUserIsOnStayReviewPage() {
        Assert.assertTrue(stayListingPage.isStayReviewPageDisplayed());
    }

    @And("print stay details")
    public void printStayDetails() {
        stayListingPage.printStayDetails();
        stayListingPage.printPriceDetails();
    }

    @When("user fills {string},{string} and {string}")
    public void userFillsAnd(String firstname, String lastname, String email) {
        stayListingPage.fillDetails(firstname, lastname, email);
    }

    @And("clicks on complete booking button")
    public void clicksOnCompleteBookingButton() {
        stayListingPage.clickOnCompleteBookingButton();
    }

    @Then("verify error message is displayed")
    public void verifyErrorMessageIsDisplayed() {
        Assert.assertTrue(stayListingPage.isErrorMessageDisplayed());
    }

    @When("user selects {string}")
    public void userSelects(String filterName) {
        stayListingPage.clickOnFilterOption(filterName);
    }

    @Then("verify hotels with only {string} is displayed")
    public void verifyHotelsWithOnlyIsDisplayed(String filterName) {
        Assert.assertTrue(stayListingPage.isFilterOptionDisplayed(filterName));
    }
}
