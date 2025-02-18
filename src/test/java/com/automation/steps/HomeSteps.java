package com.automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps extends BaseSteps{
    @Given("user open application")
    public void userOpenApplication() {
        homePage.openApplication();
    }

    @Then("verify user is on home page")
    public void verifyUserIsOnHomePage() {
       Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user click on sign in button")
    public void userClickOnSignInButton() {
        homePage.clickOnSignInButton();
    }
    @Then("verify user signed in successfully")
    public void verifyUserSignedInSuccessfully() {
        Assert.assertTrue(homePage.isAccountElementDisplayed());
    }
    @When("user clicks on account icon")
    public void userClicksOnAccountIcon() {
        homePage.clickOnAccountElement();
    }
    @Then("verify user is on account page")
    public void verifyUserIsOnAccountPage() {
    }
    @When("user click on sign out button")
    public void userClickOnSignOutButton() {
        homePage.clickOnSignOutButton();
    }
    @Then("verify user signed out successfully")
    public void verifyUserSignedOutSuccessfully() {
       Assert.assertTrue(homePage.isSignInElementDisplayed());
    }

    @When("user clicks on flights option")
    public void userClicksOnFlightsOption() {
        homePage.clickOnFlightsOption();
    }


}
