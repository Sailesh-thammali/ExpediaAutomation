package com.automation.steps;

import com.automation.interfaces.HomePage;
import com.automation.interfaces.SignInPage;
import com.automation.pages.WebHomePage;
import com.automation.pages.WebSignInPage;

public class BaseSteps {
    HomePage homePage;
    SignInPage signInPage;
    public BaseSteps() {

        homePage= new WebHomePage();
        signInPage=new WebSignInPage();

    }
}
