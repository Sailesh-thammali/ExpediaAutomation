package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignInSteps extends BaseSteps{
    @Then("verify user is on sign in page")
    public void verifyUserIsOnSignInPage() {
        Assert.assertTrue(signInPage.isSignInPageDisplayed());
    }

    @When("user enter {string} and {string}")
    public void userEnterAnd(String email, String password) {
        signInPage.enterCredentials(ConfigReader.getConfigValue("signIn.email"),ConfigReader.getConfigValue("signIn.password"));

    }

    @And("click on continue")
    public void clickOnContinue() {
        signInPage.clickOnSignInButton();
    }

    @When("user enter {string}")
    public void userEnter(String email) {

        signInPage.enterEmail(email);
    }

    @Then("verify error message is displayed {string}")
    public void verifyErrorMessageIsDisplayed(String arg0) {
       Assert.assertTrue(signInPage.isErrorMessageDisplayed());
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        signInPage.clickOnContinueButton();

    }
}
