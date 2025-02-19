package com.automation.steps;

import com.automation.interfaces.*;

import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.android.AndroidSigninPage;
import com.automation.pages.web.*;


public class BaseSteps {
    HomePage homePage;
    SignInPage signInPage;
    FlightSearchPage flightSearchPage;
    FlightListingPage flightListingPage;
    ReviewPage reviewPage;
    public BaseSteps() {
        if(System.getProperty("platfrom","web").equals("web")) {
            homePage = new WebHomePage();
            signInPage = new WebSignInPage();
            flightSearchPage = new WebFlightSearchPage();
            flightListingPage = new WebFlightListingPage();
            reviewPage = new WebReviewPage();
        }
        else {
            homePage=new AndroidHomePage();
            signInPage = new AndroidSigninPage();
        }

    }
}
