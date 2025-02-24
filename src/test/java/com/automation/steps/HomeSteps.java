package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps extends BaseSteps {
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


    @When("user clicks on cars option")
    public void userClicksOnCarsOption() {
        homePage.clickOnCarsOption();
    }

    @When("user clicks on stays option")
    public void userClicksOnStaysOption() {
        homePage.clickOnStaysOption();
    }

    @When("user clicks on region button")
    public void userClicksOnRegionButton() {
        homePage.clickOnRegionButton();
    }

    @Then("verify region options are displayed")
    public void verifyRegionOptionsAreDisplayed() {
        Assert.assertTrue(homePage.isRegionOptionDisplayed());
    }

    @When("user selects {string} and {string}")
    public void userSelectsAnd(String arg0, String arg1) {
        homePage.selectRegionOption(ConfigReader.getConfigValue("region"));
        homePage.selectLanguageOption(ConfigReader.getConfigValue("language"));
    }

    @And("clicks on save button")
    public void clicksOnSaveButton() {
        homePage.clickOnSaveButton();
    }

    @Then("verify user selected language is displayed")
    public void verifyUserSelectedLanguageIsDisplayed() {
        Assert.assertTrue(homePage.isSelectedLanguageDisplayed(ConfigReader.getConfigValue("language")));
    }
}
