package com.automation.steps;

import com.automation.interfaces.HomePage;
import com.automation.interfaces.SignInPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebSignInPage;

public class BaseSteps {
    HomePage homePage;
    SignInPage signInPage;
    public BaseSteps() {

        homePage= new WebHomePage();
        signInPage=new WebSignInPage();

    }
}
