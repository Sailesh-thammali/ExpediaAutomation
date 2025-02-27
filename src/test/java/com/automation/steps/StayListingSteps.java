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
}
