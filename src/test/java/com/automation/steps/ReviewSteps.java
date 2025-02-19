package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ReviewSteps extends BaseSteps{
    @Then("verify user is on review page")
    public void verifyUserIsOnReviewPage() {
        Assert.assertTrue(reviewPage.isReviewPageDisplayed());

    }

    @And("print flight details and price")
    public void printFlightDetailsAndPrice() {
        reviewPage.printFlightInformation();
        reviewPage.printPriceDetails();
    }
}
