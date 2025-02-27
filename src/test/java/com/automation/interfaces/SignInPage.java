package com.automation.interfaces;

public interface SignInPage {
    void enterCredentials(String email, String password);

    void clickOnSignInButton();

    void clickOnContinueButton();

    boolean isSignInPageDisplayed();

    void enterEmail(String email);

    boolean isErrorMessageDisplayed();
}
