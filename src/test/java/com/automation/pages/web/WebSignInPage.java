package com.automation.pages.web;

import com.automation.interfaces.SignInPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebSignInPage extends WebBasePage implements SignInPage {

    @FindBy(id = "loginFormEmailInput")
    WebElement emailInput;

    @FindBy(id = "loginFormSubmitButton")
    WebElement continueButton;

    @FindBy(id = "passwordButton")
    WebElement passwordButton;

    @FindBy(id = "enterPasswordFormPasswordInput")
    WebElement passwordInput;

    @FindBy(id = "enterPasswordFormSubmitButton")
    WebElement signInButton;

    @FindBy(xpath = "//div[contains(@class,'uitk-banner-critical')]")
    WebElement errorMessage;

    public void enterCredentials(String email, String password) {
        emailInput.sendKeys(email);
        continueButton.click();
        passwordButton.click();
        passwordInput.sendKeys(password);

    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }


    public void clickOnSignInButton() {
        signInButton.click();
    }

    public boolean isSignInPageDisplayed() {
        return emailInput.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        System.out.println(errorMessage.getText());
        return errorMessage.isDisplayed();
    }
}
