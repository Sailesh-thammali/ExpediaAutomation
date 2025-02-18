package com.automation.interfaces;

public interface SignInPage {
     void enterCredentials(String email,String password);
     void clickOnSignInButton();
     boolean isSignInPageDisplayed();
}
