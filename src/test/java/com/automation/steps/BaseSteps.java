package com.automation.steps;

import com.automation.interfaces.*;

import com.automation.pages.web.*;


public class BaseSteps {
    HomePage homePage;
    SignInPage signInPage;
    FlightSearchPage flightSearchPage;
    FlightListingPage flightListingPage;
    ReviewPage reviewPage;
    public BaseSteps() {

        homePage= new WebHomePage();
        signInPage=new WebSignInPage();
        flightSearchPage=new WebFlightSearchPage();
        flightListingPage=new WebFlightListingPage();
        reviewPage=  new WebReviewPage();

    }
}
